
package tech.seekback.controllers;

import tech.seekback.models.Telefono;
import tech.seekback.services.TelefonoService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author danny
 */
@SessionScoped
@Named
public class TelefonoController extends CustomController implements Serializable {

  @EJB
  private TelefonoService telefonoService;
  private Telefono telefono;

  public Telefono getTelefono(Integer idUsuario) {
    try {
      if (Objects.isNull(telefono)) {
        telefono = telefonoService.getByIdUsuario(idUsuario);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los telefono.....");
      ex.printStackTrace();
    }
    return telefono;
  }

}
