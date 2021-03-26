
package tech.seekback.controllers;

import tech.seekback.models.Divisa;
import tech.seekback.services.DivisaService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author danny
 */
@Named
@ViewScoped
public class DivisaController extends CustomController implements Serializable {

  @EJB
  private DivisaService divisaService;
  private List<Divisa> divisas;

  public List<Divisa> getDivisas() {
    try {
      if (Objects.isNull(divisas)) {
        divisas = divisaService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los clientes.....");
      ex.printStackTrace();
    }
    return divisas;
  }

}
