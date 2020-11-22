/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Cliente;
import tech.seekback.models.Empleado;
import tech.seekback.models.EstadosFidelizacion;
import tech.seekback.models.Producto;
import tech.seekback.models.SoporteTecnico;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class SoporteTecnicoBuilder {

  private SoporteTecnico soporteTecnico;

  private SoporteTecnicoBuilder() {
    this.soporteTecnico = new SoporteTecnico();
  }

  public static SoporteTecnicoBuilder builder() {
    return new SoporteTecnicoBuilder();
  }

  public SoporteTecnicoBuilder id(Integer id) {
    this.soporteTecnico.setId(id);
    return this;
  }

  public SoporteTecnicoBuilder producto(Producto producto) {
    this.soporteTecnico.setProducto(producto);
    return this;
  }

  public SoporteTecnicoBuilder cliente(Cliente cliente) {
    this.soporteTecnico.setCliente(cliente);
    return this;
  }

  public SoporteTecnicoBuilder empleado(Empleado empleado) {
    this.soporteTecnico.setEmpleado(empleado);
    return this;
  }

  public SoporteTecnicoBuilder comentario(String comentario) {
    this.soporteTecnico.setComentario(comentario);
    return this;
  }

  public SoporteTecnicoBuilder idEstado(EstadosFidelizacion estado) {
    this.soporteTecnico.setEstado(estado);
    return this;
  }

  public SoporteTecnicoBuilder timestamps(Timestamps timestamps) {
    this.soporteTecnico.setTimestamps(timestamps);
    return this;
  }

  public SoporteTecnico build() {
    return this.soporteTecnico;
  }
}
