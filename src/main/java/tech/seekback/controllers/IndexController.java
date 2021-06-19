package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Producto;
import tech.seekback.models.Slide;
import tech.seekback.services.ProductoService;
import tech.seekback.services.SlideService;
import tech.seekback.tools.MailService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author gkentaurus
 */
@Named
@ViewScoped
public class IndexController extends CustomController implements Serializable {

  @EJB
  private MailService mailService;

  @EJB
  private ProductoService productoService;

  @EJB
  private SlideService slideService;

  private List<Slide> slides;
  private String recipient;
  private String name;
  private String message;

  public void sendMessage() throws MessagingException {
    mailService.sendEmail(
            "carlos.moreno@metasysco.com",
            "Contacto desde el formulario de la página",
            name + " (" + recipient + ") escribió el siguiente mensaje:\n\n"
            + "'" + message + "'.\n\n"
            + "Por favor póngase en contacto con el cliente.\n\n"
            + "Cordialmente,\n"
            + "El equipo de desarrollo de Seekback."
    );

    mailService.sendEmail(
            recipient,
            "Gracias por contactarnos.",
            "Hola " + name + ":\n\n"
            + "Hemos recibido tu mensaje, pronto estaremos en contacto contigo.\n\n"
            + "Cordialmente,\n"
            + "El equipo de desarrollo de Seekback."
    );

    this.recipient = "";
    this.message = "";
    this.name = "";
  }

  // <editor-fold desc="Getters y Setters" defaultstate="collapsed">
  public List<Producto> getLastProducts(Integer limit) throws ConnectionExcep {
    return this.productoService.getLastProducts(limit);
  }

  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
  // </editor-fold>

  public List<Slide> getPaises() {
    try {
      if (Objects.isNull(slides)) {
        slides = slideService.getAll();
      }
    } catch (ConnectionExcep ex) {
      System.out.println("Error de la consulta 'slides'.");
      ex.printStackTrace();
    }
    return slides;
  }

}
