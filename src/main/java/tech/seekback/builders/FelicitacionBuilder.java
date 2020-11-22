/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Cliente;
import tech.seekback.models.Felicitacion;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class FelicitacionBuilder {

  private Felicitacion felicitacion;

  private FelicitacionBuilder() {
    this.felicitacion = new Felicitacion();
  }

  public static FelicitacionBuilder builder() {
    return new FelicitacionBuilder();
  }

  public FelicitacionBuilder id(Integer id) {
    this.felicitacion.setId(id);
    return this;
  }

  public FelicitacionBuilder cliente(Cliente cliente) {
    this.felicitacion.setCliente(cliente);
    return this;
  }

  public FelicitacionBuilder dirigidoA(String dirigidoA) {
    this.felicitacion.setDirigidoA(dirigidoA);
    return this;
  }

  public FelicitacionBuilder comentario(String comentario) {
    this.felicitacion.setComentario(comentario);
    return this;
  }

  public FelicitacionBuilder timestamps(Timestamps timestamps) {
    this.felicitacion.setTimestamps(timestamps);
    return this;
  }

  public Felicitacion build() {
    return this.felicitacion;
  }

}
