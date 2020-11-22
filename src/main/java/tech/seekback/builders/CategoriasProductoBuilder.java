/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.CategoriasProducto;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class CategoriasProductoBuilder {

  private CategoriasProducto categoriasProducto;

  private CategoriasProductoBuilder() {
    this.categoriasProducto = new CategoriasProducto();
  }

  public static CategoriasProductoBuilder builder() {
    return new CategoriasProductoBuilder();
  }

  public CategoriasProductoBuilder id(Integer id) {
    this.categoriasProducto.setId(id);
    return this;
  }

  public CategoriasProductoBuilder nombreCategoria(String nombreCategoria) {
    this.categoriasProducto.setNombreCategoria(nombreCategoria);
    return this;
  }

  public CategoriasProductoBuilder timestamps(Timestamps timestamps) {
    this.categoriasProducto.setTimestamps(timestamps);
    return this;
  }

  public CategoriasProducto build() {
    return this.categoriasProducto;
  }
}
