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

  public static BodegaProductosBuilder builder() {
    return new BodegaProductosBuilder();
  }

  public BodegaProductosBuilder id(Integer id) {
    this.bodegaProductos.setId(id);
    return this;
  }

  public BodegaProductosBuilder bodega(Bodega bodega) {
    this.bodegaProductos.setBodega(bodega);
    return this;
  }

  public BodegaProductosBuilder producto(Producto producto) {
    this.bodegaProductos.setProducto(producto);
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
