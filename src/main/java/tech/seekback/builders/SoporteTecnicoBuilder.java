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

  public SoporteTecnicoBuilder idSoporteTecnico(Integer idSoporteTecnico) {
    this.soporteTecnico.setIdSoporteTecnico(idSoporteTecnico);
    return this;
  }

  public SoporteTecnicoBuilder idProducto(Producto idProducto) {
    this.soporteTecnico.setIdProducto(idProducto);
    return this;
  }

  public SoporteTecnicoBuilder idCliente(Cliente idCliente) {
    this.soporteTecnico.setIdCliente(idCliente);
    return this;
  }

  public SoporteTecnicoBuilder idEmpleado(Empleado idEmpleado) {
    this.soporteTecnico.setIdEmpleado(idEmpleado);
    return this;
  }

  public SoporteTecnicoBuilder comentario(String comentario) {
    this.soporteTecnico.setComentario(comentario);
    return this;
  }

  public SoporteTecnicoBuilder idEstado(EstadosFidelizacion idEstado) {
    this.soporteTecnico.setIdEstado(idEstado);
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
