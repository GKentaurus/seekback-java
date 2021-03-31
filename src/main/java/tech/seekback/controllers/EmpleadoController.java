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
import tech.seekback.models.Usuario;
import tech.seekback.services.EmpleadoService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class EmpleadoController extends CustomController implements Serializable {

  @EJB
  private EmpleadoService empleadoService;
  private List<Usuario> empleados;

  public List<Usuario> getEmpleados() {
    try {
      if (Objects.isNull(empleados)) {
        empleados = empleadoService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los clientes.....");
      ex.printStackTrace();
    }
    return empleados;
  }

}
