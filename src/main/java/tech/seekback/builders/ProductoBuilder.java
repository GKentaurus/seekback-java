
package tech.seekback.builders;

import tech.seekback.models.CategoriasProducto;
import tech.seekback.models.Producto;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class ProductoBuilder {

  private final Producto producto;

  private ProductoBuilder() {
    this.producto = new Producto();
  }

  public static ProductoBuilder builder() {
    return new ProductoBuilder();
  }

  public ProductoBuilder id(Integer id) {
    this.producto.setId(id);
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

  public ProductoBuilder categoria(CategoriasProducto categoria) {
    this.producto.setCategoria(categoria);
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
