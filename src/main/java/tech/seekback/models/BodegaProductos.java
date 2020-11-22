/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "bodega_productos")
@NamedQueries(value = {
  @NamedQuery(name = "BodegaProductos.getAll", query = "SELECT obj FROM BodegaProductos obj")
})
public class BodegaProductos implements Serializable {

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
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Bodega getBodega() {
    return bodega;
  }

  public void setBodega(Bodega bodega) {
    this.bodega = bodega;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
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
