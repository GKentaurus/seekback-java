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
import tech.seekback.models.Divisa;
import tech.seekback.services.DivisaService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class DivisaController implements Serializable {

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
