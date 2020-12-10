/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import tech.seekback.models.Correo;
import tech.seekback.models.Telefono;
import tech.seekback.models.Usuario;
import tech.seekback.services.CorreoService;
import tech.seekback.services.TelefonoService;

/**
 *
 * @author danny
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

  @EJB
  private TelefonoService telefonoService;

  @EJB
  private CorreoService correosService;
  private String password;
  private String email;
  private Usuario usuario;
  private Correo correo;
  private boolean checkLogin;
  private String ruta;
  private Telefono telefono;

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

  public Telefono getTelefono() {
    return telefono;
  }

  public void setTelefono(Telefono telefono) {
    this.telefono = telefono;
  }

  public String login() {
    FacesContext fc = FacesContext.getCurrentInstance();
    System.out.println("mire vea");
    try {
      this.correo = correosService.getByCorreo(email);
      if (Objects.isNull(email)) {
        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add("alert('peek-a-boo');");
      }

      if (!this.correo.getUsuario().verificarContrasena(this.password)) {
        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add("alert('peek-a-boo');");
      } else {
        usuario = this.correo.getUsuario();
        telefono = telefonoService.getByIdUsuario(this.correo.getUsuario().getId());
      }

      switch (this.correo.getUsuario().getRol().getNombreRol()) {
        case "Administrador":
          ExternalContext ad = fc.getExternalContext();
          ad.redirect(ad.getRequestContextPath() + "/frames/admin.xhtml");
          break;
        case "Empleado":
          ExternalContext em = fc.getExternalContext();
          em.redirect(em.getRequestContextPath() + "/frames/empleado.xhtml");
          break;
        case "Cliente":
          ExternalContext cl = fc.getExternalContext();
          cl.redirect(cl.getRequestContextPath() + "/frames/cliente.xhtml");
          break;
        default:
          this.ruta = "login.xhtml?faces-redirect=true";
      }

    } catch (Exception ex) {
      System.out.println("Error de la consulta email.");
      ex.printStackTrace();
    }
    return "";
  }

  public void exit() throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.invalidateSession();
    ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
  }

  public boolean isstarted() throws IOException {
    return Objects.nonNull(this.email);
  }

  public void validate() throws IOException {
    if (!isstarted()) {
      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
    }
  }

  public void checkislogin() throws IOException {
    //System.out.println("iniciada " + isstarted());
    if (isstarted()) {
      FacesContext fc = FacesContext.getCurrentInstance();
      //System.out.println("pues eso");

      switch (this.correo.getUsuario().getRol().getNombreRol()) {
        case "Administrador":
          ExternalContext ad = fc.getExternalContext();
          ad.redirect(ad.getRequestContextPath() + "/frames/admin.xhtml");
          // System.out.println(ad.getRequestContextPath() + " / pues eso 1");
          break;
        case "Empleado":
          ExternalContext em = fc.getExternalContext();
          em.redirect(em.getRequestContextPath() + "/frames/empleado.xhtml");
          break;
        case "Cliente":
          ExternalContext cl = fc.getExternalContext();
          cl.redirect(cl.getRequestContextPath() + "/frames/cliente.xhtml");
          break;
        default:
          this.ruta = "login.xhtml?faces-redirect=true";
      }
    }
  }

}
