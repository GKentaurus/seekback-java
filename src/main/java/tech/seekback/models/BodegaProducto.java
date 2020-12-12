/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "BodegaProducto"
 *
 * @author danny
 */
@Entity
@Table(name = "bodega_productos")
@NamedQueries(value = {
  @NamedQuery(name = "BodegaProducto.getAll", query = "SELECT obj FROM BodegaProducto obj WHERE obj.timestamps.deleted_at IS NULL")
})
public class BodegaProducto implements Serializable {

  @Id
  @Column(name = "idRegistro", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idBodega", nullable = false)
  private Bodega bodega;

  @ManyToOne(fetch = FetchType.LAZY)
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
   * @see Bodega
   * @return <code>bodega</code> de la bodega de productos.
   */
  public Bodega getBodega() {
    return bodega;
  }

  /**
   * Asigna el valor del atributo <code>bodega</code> del objeto.
   *
   * @see Bodega
   * @param bodega de la bodega de productos.
   */
  public void setBodega(Bodega bodega) {
    this.bodega = bodega;
  }

  /**
   * Retorna el valor del atributo <code>producto</code> del objeto.
   *
   * @see Producto
   * @return <code>producto</code> de la bodega de productos.
   */
  public Producto getProducto() {
    return producto;
  }

  /**
   * Asigna el valor del atributo <code>producto</code> del objeto.
   *
   * @see Producto
   * @param producto de la bodega de productos.
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
   * @see Timestamps
   * @return <code>timestamps</code> de la bodega de productos.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps de la bodega de productos.
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
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información
   * relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
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
