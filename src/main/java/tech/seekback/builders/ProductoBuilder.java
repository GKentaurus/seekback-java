/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.CategoriasProducto;
import tech.seekback.models.Producto;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class ProductoBuilder {

  private Producto producto;

  private ProductoBuilder() {
    this.producto = new Producto();
  }

  public static ProductoBuilder builder() {
    return new ProductoBuilder();
  }

  public ProductoBuilder idProducto(Integer idProducto) {
    this.producto.setIdProducto(idProducto);
    return this;
  }

  public ProductoBuilder modeloProducto(String modeloProducto) {
    this.producto.setModeloProducto(modeloProducto);
    return this;
  }

  public ProductoBuilder descripcion(String descripcion) {
    this.producto.setDescripcion(descripcion);
    return this;
  }

  public ProductoBuilder precioVenta(Double precioVenta) {
    this.producto.setPrecioVenta(precioVenta);
    return this;
  }

  public ProductoBuilder idCategoria(CategoriasProducto idCategoria) {
    this.producto.setIdCategoria(idCategoria);
    return this;
  }

  public ProductoBuilder estado(Boolean estado) {
    this.producto.setEstado(estado);
    return this;
  }

  public ProductoBuilder timestamps(Timestamps timestamps) {
    this.producto.setTimestamps(timestamps);
    return this;
  }

  public Producto build() {
    return this.producto;
  }
}
