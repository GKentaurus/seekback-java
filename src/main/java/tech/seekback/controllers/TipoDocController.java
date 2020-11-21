/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoDoc;
import tech.seekback.services.TipoDocService;

/**
 *
 * @author camorenoc
 */
@Named
@ViewScoped
public class TipoDocController implements Serializable {

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
    }
  }

  public List<TipoDoc> getTipoDocs() {
    return tipoDocs;
  }
}
