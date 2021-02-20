/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Pais;
import tech.seekback.services.PaisService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class PaisController extends CustomController implements Serializable {

  @EJB
  private PaisService paisService;
  private List<Pais> paises;

  public List<Pais> getPaises() {
    try {
      if (Objects.isNull(paises)) {
        paises = paisService.getAll();
      }
    } catch (ConnectionExcep ex) {
      System.out.println("Error de la consulta 'paises'.");
      ex.printStackTrace();
    }
    return paises;

  }

}
