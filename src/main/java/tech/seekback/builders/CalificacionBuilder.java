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

  public CalificacionBuilder idCalificacion(Integer idCalificacion) {
    this.calificacion.setIdCalificacion(idCalificacion);
    return this;
  }

  public CalificacionBuilder idCliente(Cliente idCliente) {
    this.calificacion.setIdCliente(idCliente);
    return this;
  }

  public CalificacionBuilder idProducto(Producto idProducto) {
    this.calificacion.setIdProducto(idProducto);
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
