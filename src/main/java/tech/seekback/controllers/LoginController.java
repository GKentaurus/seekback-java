
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correo;
import tech.seekback.models.Usuario;
import tech.seekback.services.CorreoService;
import tech.seekback.services.UsuarioService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author danny
 */
@Named
@SessionScoped
public class LoginController extends CustomController implements Serializable {

  @EJB
  private UsuarioService usuarioService;

  @EJB
  private CorreoService correosService;

  private Usuario usuario;
  private Correo correo;

  private String password;
  private String email;
  private String ruta;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Correo getCorreo() {
    return correo;
  }

  public void setCorreo(Correo correo) {
    this.correo = correo;
  }
//</editor-fold>

  public void login() throws ConnectionExcep, IOException {
    FacesContext fc = FacesContext.getCurrentInstance();
    // TODO: Enviar los mensajes de error o confirmación a través de addMessage()

    // Validar si el correo existe
    this.correo = new Correo();
    this.correo = correosService.getByCorreo(email);
    if (Objects.nonNull(correo)) {
      this.usuario = new Usuario();
      this.usuario = usuarioService.getOne(correo.getUsuario().getId());
      if (Objects.nonNull(usuario)) {
        if (usuario.verificarContrasena(password)) {
          redirectTo(usuario.getRol().getId());
        } else {
          this.usuario = null;
          FacesMessage message = new FacesMessage("Contraseña invalida");
          fc.addMessage("messs:mesag", message);
        }
      } else {
        FacesMessage message = new FacesMessage("El  no esta registrado");
        fc.addMessage("messs:mesag", message);
        this.usuario = null;
      }
    } else {
      this.correo = null;
      FacesMessage message = new FacesMessage("El correo no esta registrado");
      fc.addMessage("messs:mesag", message);
      System.out.println("!!! Correo no existente !!!");
    }
  }

  public void logout() throws IOException {
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();
    ec.invalidateSession();
    ec.redirect(ec.getRequestContextPath() + "/login.xhtml");

  }

  public boolean isLogged() throws IOException {
    return Objects.nonNull(usuario);
  }

  public void validate() throws IOException {
    if (isLogged()) {
      redirectTo(usuario.getRol().getId());
    }
  }

  public void validate(Integer rol) throws IOException {
    if (isLogged()) {
      if (!Objects.equals(rol, usuario.getRol().getId())) {
        redirectTo("/index.xhtml");
      }
    } else {
      redirectTo("/errorPages/403.xhtml");
    }
  }

  public void redirectTo(String ruta) throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + ruta);
  }

  public void redirectTo(Integer rol) throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    switch (rol) {
      case 1: // Administrador
        this.ruta = "/frames/admin.xhtml";
        break;
      case 2: // Empleado
        this.ruta = "/frames/empleado.xhtml";
        break;
      case 3: // Cliente
        this.ruta = "/frames/cliente.xhtml";
        break;
      default:
        this.ruta = "/index.xhtml";
        break;
    }
    ec.redirect(ec.getRequestContextPath() + ruta);
  }

}
