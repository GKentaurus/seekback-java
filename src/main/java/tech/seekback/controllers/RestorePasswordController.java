/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correo;
import tech.seekback.models.Usuario;
import tech.seekback.services.CorreoService;
import tech.seekback.services.UsuarioService;
import tech.seekback.services.tools.MailService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class RestorePasswordController implements Serializable {

  @EJB
  private UsuarioService usuarioService;

  @EJB
  private CorreoService correosService;

  @EJB
  private MailService mailService;

  private boolean cuentaReactivada = false;
  private Usuario usuario;
  private Correo correo;

  private String email;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

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
  }

  public void redirectTo(String ruta) throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + ruta);
  }

}
