package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.util.Objects;

/**
 * Definición del modelo "BodegaProducto"
 *
 * @author danny
 */
@Entity
@Table(name = "bodega_productos")
@NamedQueries(value = {
  @NamedQuery(name = "BodegaProducto.getAll", query = "SELECT obj FROM BodegaProducto obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "BodegaProducto.getLikeName", query = "SELECT obj FROM BodegaProducto obj WHERE  obj.producto.modeloProducto like CONCAT('%', :parteNombre, '%') AND obj.timestamps.deleted = false"),
  @NamedQuery(name = "BodegaProducto.getByIdCategoria", query = "SELECT obj FROM BodegaProducto obj WHERE  obj.producto.categoria.id = :idCategoria AND obj.timestamps.deleted = false"),
  @NamedQuery(name = "BodegaProducto.getByIdProducto", query = "SELECT obj FROM BodegaProducto obj WHERE  obj.producto.id = :idProducto AND obj.timestamps.deleted = false")
})
public class BodegaProducto implements EntityTimestamp {

  @Id
  @Column(name = "idRegistro", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idBodega", nullable = false)
  private Bodega bodega;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idProducto", nullable = false)
  private Producto producto;

  @Column(name = "cantidad", nullable = false, length = 11)
  private Integer cantidad;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la bodega de productos.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la bodega de productos.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>bodega</code> del objeto.
   *
   * @return <code>bodega</code> de la bodega de productos.
   * @see Bodega
   */
  public Bodega getBodega() {
    return bodega;
  }

  /**
   * Asigna el valor del atributo <code>bodega</code> del objeto.
   *
   * @param bodega de la bodega de productos.
   * @see Bodega
   */
  public void setBodega(Bodega bodega) {
    this.bodega = bodega;
  }

  /**
   * Retorna el valor del atributo <code>producto</code> del objeto.
   *
   * @return <code>producto</code> de la bodega de productos.
   * @see Producto
   */
  public Producto getProducto() {
    return producto;
  }

  /**
   * Asigna el valor del atributo <code>producto</code> del objeto.
   *
   * @param producto de la bodega de productos.
   * @see Producto
   */
  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  /**
   * Retorna el valor del atributo <code>cantidad</code> del objeto.
   *
   * @return <code>cantidad</code> de la bodega de productos.
   */
  public Integer getCantidad() {
    return cantidad;
  }

  /**
   * Asigna el valor del atributo <code>cantidad</code> del objeto.
   *
   * @param cantidad de la bodega de productos.
   */
  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> de la bodega de productos.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de la bodega de productos.
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 11 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final BodegaProducto other = (BodegaProducto) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "BodegaProductos("
            + "id = " + id + ", "
            + "bodega = " + bodega + ", "
            + "producto = " + producto + ", "
            + "cantidad = " + cantidad + ", "
            + timestamps.toString()
            + ")";
  }

}
