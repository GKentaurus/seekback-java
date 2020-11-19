/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Bodega;
import tech.seekback.models.BodegaProductos;
import tech.seekback.models.Producto;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class BodegaProductosBuilder {

  private BodegaProductos bodegaProductos;

  private BodegaProductosBuilder() {
    this.bodegaProductos = new BodegaProductos();
  }

  public BodegaProductosBuilder idRegistro(Integer idRegistro) {
    this.bodegaProductos.setIdRegistro(idRegistro);
    return this;
  }

  public BodegaProductosBuilder idBodega(Bodega idBodega) {
    this.bodegaProductos.setIdBodega(idBodega);
    return this;
  }

  public BodegaProductosBuilder idProducto(Producto idProducto) {
    this.bodegaProductos.setIdProducto(idProducto);
    return this;
  }

  public BodegaProductosBuilder cantidad(Integer cantidad) {
    this.bodegaProductos.setCantidad(cantidad);
    return this;
  }

  public BodegaProductosBuilder timestamps(Timestamps timestamps) {
    this.bodegaProductos.setTimestamps(timestamps);
    return this;
  }

  public BodegaProductos build() {
    return this.bodegaProductos;
  }
}
