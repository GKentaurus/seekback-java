
package tech.seekback.builders;

import tech.seekback.models.Empleado;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class EmpleadoBuilder {

  private final Empleado empleado;

  private EmpleadoBuilder() {
    this.empleado = new Empleado();
  }

  public static EmpleadoBuilder builder() {
    return new EmpleadoBuilder();
  }

  public EmpleadoBuilder empleado(Integer empleado) {
    this.empleado.setId(empleado);
    return this;
  }

  public EmpleadoBuilder usuario(Usuario usuario) {
    this.empleado.setUsuario(usuario);
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
