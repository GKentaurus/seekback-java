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
public class BodegaProductos implements Serializable {

  @Id
  @Column(name = "idRegistro", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idRegistro;

  @Column(name = "idBodega", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idBodega", referencedColumnName = "idBodega")
  private Bodega idBodega;

  @Column(name = "idProducto", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
  private Producto idProducto;

  @Column(name = "cantidad", nullable = false, length = 11)
  private Integer cantidad;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdRegistro() {
    return idRegistro;
  }

  public void setIdRegistro(Integer idRegistro) {
    this.idRegistro = idRegistro;
  }

  public Bodega getIdBodega() {
    return idBodega;
  }

  public void setIdBodega(Bodega idBodega) {
    this.idBodega = idBodega;
  }

  public Producto getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Producto idProducto) {
    this.idProducto = idProducto;
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
            + "id = " + idRegistro + ", "
            + "idBodega = " + idBodega + ", "
            + "idProducto = " + idProducto + ", "
            + "Cantidad = " + cantidad + ", "
            + timestamps.toString()
            + ")";
  }

}
