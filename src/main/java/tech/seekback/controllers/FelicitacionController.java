/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Felicitacion;
import tech.seekback.services.FelicitacionService;

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
public class FelicitacionController extends CustomController implements Serializable {

  @EJB
  private FelicitacionService felicitacionService;
  private List<Felicitacion> felicitaciones;
  private Integer count;

  public Integer getCount() {
    try {
      if (count == null) {
        count = felicitacionService.getAllCount();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return count;
  }

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

  public void delete(Felicitacion felicitacion) throws ConnectionExcep {
    felicitacionService.delete(felicitacion);
  }

}
