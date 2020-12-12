/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.models.Felicitacion;
import tech.seekback.services.FelicitacionService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class FelicitacionController implements Serializable {

  @EJB
  private FelicitacionService felicitacionService;
  private List<Felicitacion> felicitaciones;

  public List<Felicitacion> getFelicitaciones() {
    try {
      if (Objects.isNull(felicitaciones)) {
        felicitaciones = felicitacionService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los felicitaciones.....");
      ex.printStackTrace();
    }
    return felicitaciones;
  }

}
