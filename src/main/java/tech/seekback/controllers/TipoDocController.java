/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author camorenoc
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
