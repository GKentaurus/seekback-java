
package tech.seekback.builders;

import tech.seekback.models.CategoriasProducto;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class CategoriasProductoBuilder {

  private final CategoriasProducto categoriasProducto;

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
