
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoDoc;
import tech.seekback.services.TipoDocService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author gkentaurus
 */
@Named
@ViewScoped
public class TipoDocController extends CustomController implements Serializable {

  @EJB
  private TipoDocService tipoDocService;
  private List<TipoDoc> tipoDocs;

  public TipoDocController() {
  }

  @PostConstruct
  public void init() {
    try {
      tipoDocs = tipoDocService.getAll();
    } catch (ConnectionExcep ex) {
      System.out.println("Error de la consulta 'TIPO DOC'.");
      ex.printStackTrace();
    }
  }

  public List<TipoDoc> getTipoDocs() {
    return tipoDocs;
  }
}
