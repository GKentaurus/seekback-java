package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correo;
import tech.seekback.models.Usuario;
import tech.seekback.services.CorreoService;
import tech.seekback.services.UsuarioService;
import tech.seekback.services.tools.MailService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.MessagingException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

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

  @EJB
  private MailService mailService;

  // TODO: Usar este boolean en la vista de perfil de usuario, para mostrar un mensaje que diga "Bienvenido de vuelta"
  private boolean cuentaReactivada = false;
  private Usuario usuario;
  private Correo correo;

  private String password;
  private String email;

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

  public boolean getCuentaReactivada() {
    return cuentaReactivada;
  }

  public void setCuentaReactivada(boolean cuentaReactivada) {
    this.cuentaReactivada = cuentaReactivada;
  }
//</editor-fold>

  private boolean validateEmail() throws ConnectionExcep {
    // Validar si el correo existe
    this.correo = new Correo();
    this.correo = correosService.getByCorreo(email);
    return Objects.nonNull(correo);
  }

  private boolean validateUser() throws ConnectionExcep {
    this.usuario = new Usuario();
    this.usuario = usuarioService.getOne(correo.getUsuario().getId());
    return Objects.nonNull(usuario);
  }

  private void reactiveUser() throws ConnectionExcep {
    if (this.usuario.getTimestamps().getDeleted()) {
      System.out.println("Restaurando usuario eliminado");
      this.usuario.getTimestamps().setDeleted(false);
      this.usuario.getTimestamps().resetDeleted_at();
      this.usuarioService.update(this.usuario);
      this.cuentaReactivada = true;
    }
  }

  public void login() throws ConnectionExcep, IOException {
    FacesContext fc = FacesContext.getCurrentInstance();
    // TODO: Enviar los mensajes de error o confirmación a través de addMessage()

    if (validateEmail()) {
      if (validateUser()) {
        if (usuario.verificarContrasena(password)) {
          reactiveUser();
          redirectTo(usuario.getRol().getId());
        } else {
          this.usuario = null;
          FacesMessage message = new FacesMessage("Contraseña invalida");
          fc.addMessage("messs:mesag", message);
        }
      } else {
        FacesMessage message = new FacesMessage("El usuario no esta registrado");
        fc.addMessage("messs:mesag", message);
        this.usuario = null;
      }
    } else {
      this.correo = null;
      FacesMessage message = new FacesMessage("El correo no esta registrado");
      fc.addMessage("messs:mesag", message);
    }
  }

  public void restorePassword() throws ConnectionExcep, MessagingException, IOException {
    System.out.println("Recuperando contraseña...");
    FacesContext fc = FacesContext.getCurrentInstance();
    if (validateEmail()) {
      if (validateUser()) {
        String alphabet = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
        String temporalPassword = "";
        Random rrn = new Random();
        for (int i = 0; i < 10; i++) {
          int randomIndex = rrn.nextInt(alphabet.length() - 1);
          temporalPassword = temporalPassword.concat(alphabet.substring(randomIndex, randomIndex + 1));
        }
        usuario.setContrasena(temporalPassword);
        usuarioService.update(usuario);
        this.mailService.sendEmail(
                this.correo.getCorreoElectronico(),
                "¿Olvidaste tu contraseña en Seekback?",
                "Hola" + this.usuario.getPrimerNombre() + " " + this.usuario.getOtrosNombres() + ":\n\n"
                + "Su nueva contraseña es " + temporalPassword + "\n\n"
                + "Usala para iniciar sesión la próxima vez. Le recomendamos la cambie tan pronto sea posible.\n\n"
                + "Cordialmente,\n\n"
                + "El equipo de desarrollo de Seekback");
      } else {
        FacesMessage message = new FacesMessage("El usuario no esta registrado");
        fc.addMessage("messs:mesag", message);
        this.usuario = null;
      }
    } else {
      this.correo = null;
      FacesMessage message = new FacesMessage("El correo no esta registrado");
      fc.addMessage("messs:mesag", message);
    }
    redirectTo("/login.xhtml");
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

    String ruta;
    if (rol == null) {
      ruta = "/index.xhtml";
    } else {
      ruta = "/frames/cuenta.xhtml";
    }
    ec.redirect(ec.getRequestContextPath() + ruta);
  }
}
