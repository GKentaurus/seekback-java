/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.Objects;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import tech.seekback.models.Correos;
import tech.seekback.models.Usuario;
import tech.seekback.services.CorreosService;
import tech.seekback.services.UsuarioService;

/**
 *
 * @author danny
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

  @EJB
  private UsuarioService usuarioService;

  @EJB
  private CorreosService correosService;
  private String password;
  private String email;
  private Usuario usuario;
  private Correos correo;
  private boolean checkLogin;
  private String ruta;

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

  public String login() {
    FacesContext fc = FacesContext.getCurrentInstance();
    try {
      this.correo = correosService.getByCorreo(email);
      if (Objects.isNull(email)) {
        return "login.xhtml?faces-redirect=true";
      }

      if (!this.correo.getUsuario().verificarContrasena(this.password)) {
        return "login.xhtml?faces-redirect=true";
      }

      switch (this.correo.getUsuario().getRol().getNombreRol()) {
        case "Administrador":
          ExternalContext ec = fc.getExternalContext();
          ec.redirect(ec.getRequestContextPath() + "/frames/admin.xhtml");
          break;
        case "Empleado":
          this.ruta = "";
          break;
        case "Cliente":
          this.ruta = "";
          break;
        default:
          this.ruta = "login.xhtml?faces-redirect=true";
      }

    } catch (Exception ex) {
      System.out.println("Error de la consulta email.");
      ex.printStackTrace();
    }
    return ruta;
  }

}
