/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;
import tech.seekback.services.UsuarioService;
import tech.seekback.services.tools.MailService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author camorenoc
 */
@Named
@ViewScoped
public class TestController extends CustomController implements Serializable {

  @EJB
  private UsuarioService usuarioService;

  @EJB
  private MailService mailService;

  public void encrypt() throws ConnectionExcep {
    List<Usuario> users = new ArrayList<>();
    users = usuarioService.getAll();

    for (Usuario user : users) {
      if (user.getContrasena().length() < 20) {
        String pass = user.getContrasena();
        user.setContrasena(pass);
        usuarioService.update(user);
      }
    }
  }

  public void newEmail() {
    String recipient = "camorenoc@outlook.com";
    String subject = "Mensaje de prueba desde JavaMail";
    String message = "Y te preguntaras... ¿Por qué has recibido este correo?\n"
      + "Pos porque si... porque un tal Carlos lo quiso así, y porque quería hacer pruebas de JavaMail\n"
      + "Y si quieres gastarle una cerveza el domingo por la noche a Carlos\n"
      + "Entonces mándasela por Rappi, porque el domingo en la noche es de comida trampa y cerveza xD\n\n"
      + "PD: No es broma :C";
    mailService.sendEmail(recipient, subject, message);
  }
}
