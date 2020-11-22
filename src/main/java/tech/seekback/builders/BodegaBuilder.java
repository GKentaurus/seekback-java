/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Bodega;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class BodegaBuilder {

  private Bodega bodega;

  private BodegaBuilder() {
    this.bodega = new Bodega();
  }

  public static BodegaBuilder builder() {
    return new BodegaBuilder();
  }

  public BodegaBuilder id(Integer id) {
    this.bodega.setId(id);
    return this;
  }

  public BodegaBuilder nombreBodega(String nombreBodega) {
    this.bodega.setNombreBodega(nombreBodega);
    return this;
  }

  public BodegaBuilder timestamps(Timestamps timestamps) {
    this.bodega.setTimestamps(timestamps);
    return this;
  }

  public Bodega build() {
    return this.bodega;
  }
}
