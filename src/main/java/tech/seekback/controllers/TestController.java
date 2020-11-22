/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author camorenoc
 */
@Named
@ViewScoped
public class TestController implements Serializable {

  private String nombre;

  public TestController() {
    nombre = "Carlos";
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void saludar() {
    System.out.println("Saludo de parte de " + nombre);
  }
}
