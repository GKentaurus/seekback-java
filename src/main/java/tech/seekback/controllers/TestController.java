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
import tech.seekback.models.EstadosFidelizacion;
import tech.seekback.services.EstadosFidelizacionService;

/**
 *
 * @author camorenoc
 */
@Named
@ViewScoped
public class TestController implements Serializable {

  @EJB
  private EstadosFidelizacionService service;
  private List<EstadosFidelizacion> docs;

  public TestController() {
  }

  @PostConstruct
  public void init() {
    try {
      docs = service.getAll();
    } catch (ConnectionExcep e) {
    }
  }

  public List<EstadosFidelizacion> getDocs() {
    return this.docs;
  }

//  public String getNombre() {
//    return nombre;
//  }
//
//  public void setNombre(String nombre) {
//    this.nombre = nombre;
//  }
//
//  public void saludar() {
//    System.out.println("Saludo de parte de " + nombre);
//  }
}
