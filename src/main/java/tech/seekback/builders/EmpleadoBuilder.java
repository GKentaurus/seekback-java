/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Empleado;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class EmpleadoBuilder {

  private Empleado empleado;

  private EmpleadoBuilder() {
    this.empleado = new Empleado();
  }

  public static EmpleadoBuilder builder() {
    return new EmpleadoBuilder();
  }

  public EmpleadoBuilder idEmpleado(Integer idEmpleado) {
    this.empleado.setIdEmpleado(idEmpleado);
    return this;
  }

  //TODO: Cuando llamo set queda asi el valor
  public EmpleadoBuilder idUsuario(Usuario idUsuario) {
    this.empleado.setIdUsuario(Integer.MIN_VALUE);
    return this;
  }

  public EmpleadoBuilder timestamps(Timestamps timestamps) {
    this.empleado.setTimestamps(timestamps);
    return this;
  }

  public Empleado build() {
    return this.empleado;
  }
}
