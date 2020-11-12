/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "bodega_productos")
public class BodegaProductos extends Timestamps {

  @Id
  @Column(name = "idRegistro")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idRegistro;

  // TODO: revisar relacion con la tabla  Bodega
  @Column(name = "idBodega", nullable = false)
  @ManyToOne
  private Bodega idBodega; 

  // TODO: revisar relacion con la tabla  Producto
  @Column(name = "idProducto", nullable = false)
  @ManyToOne
  // FIXME: a espera de creacion de la tabla Producto
  private Producto idProducto; 
  
  @Column(name = "cantidad", nullable = false)
  private Integer cantidad;
  
 //TODO:  se debe revisar al crear las clases pendientes
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
  //</editor-fold>
  
  @Override
  public String toString(){
    return "BodegaProductos("
            + "id = " + idRegistro + ", "
            + "idBodega = " + idBodega + ", "
            + "idProducto = " + idProducto + ", "
            + "Cantidad = " + cantidad + ", "
            + super.toString() 
            + ")";
  }  
  
}
