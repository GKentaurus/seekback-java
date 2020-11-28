/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Ciudad;
import tech.seekback.models.Direcciones;
import tech.seekback.models.Usuario;
import tech.seekback.services.DireccionesService;

/**
 *
 * @author danny
 */
@ViewScoped
@Named
public class DireccionesController implements Serializable {

  @EJB
  private DireccionesService direccionesService;
  private Direcciones direccion;
  private List<Direcciones> direcciones;

  public DireccionesController() {
    direccion = new Direcciones();
    direccion.setCiudad(new Ciudad());
    direccion.setUsuario(new Usuario());
  }

  @PostConstruct
  public void ejec() {

  }

  public Direcciones getDireccion() {
    return direccion;
  }

  public void setDireccion(Direcciones direccion) {
    this.direccion = direccion;
  }

  public List<Direcciones> getDirecciones() throws ConnectionExcep {
    try {
      if (Objects.isNull(direcciones)) {
        direcciones = direccionesService.getAll();
      }
    } catch (ConnectionExcep ex) {
      System.out.println("Error al consultar los direcciones.....");
      ex.printStackTrace();
    }

    return direcciones;
  }

  public void create() throws ConnectionExcep {
    try {
      direccionesService.create(direccion);
    } catch (ConnectionExcep ex) {
      System.out.println("Error al registrar direccion");
      ex.printStackTrace();
    }
  }
}
