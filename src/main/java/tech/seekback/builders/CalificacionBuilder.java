/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Calificacion;
import tech.seekback.models.Cliente;
import tech.seekback.models.Producto;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class CalificacionBuilder {

  private Calificacion calificacion;

  private CalificacionBuilder() {
    this.calificacion = new Calificacion();
  }

  public static CalificacionBuilder builder() {
    return new CalificacionBuilder();
  }

  public CalificacionBuilder id(Integer id) {
    this.calificacion.setId(id);
    return this;
  }

  public CalificacionBuilder cliente(Cliente cliente) {
    this.calificacion.setCliente(cliente);
    return this;
  }

  public CalificacionBuilder producto(Producto producto) {
    this.calificacion.setProducto(producto);
    return this;
  }

  public CalificacionBuilder calificacion(Integer calificacion) {
    this.calificacion.setCalificacion(calificacion);
    return this;
  }

  public CalificacionBuilder comentario(Integer comentario) {
    this.calificacion.setCalificacion(comentario);
    return this;
  }

  public CalificacionBuilder esAprobado(Boolean esAprobado) {
    this.calificacion.setEsAprobado(esAprobado);
    return this;
  }

  public CalificacionBuilder timestamps(Timestamps timestamps) {
    this.calificacion.setTimestamps(timestamps);
    return this;
  }

  public Calificacion build() {
    return this.calificacion;
  }
}
