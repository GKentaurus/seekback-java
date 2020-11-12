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
@Table(name = "calificacion")
public class Calificacion extends Timestamps {

  @Id
  @Column(name = "idCalificacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCalificacion;

  // TODO: revisar relacion con la tabla  Producto
  @Column(name = "idProducto", nullable = false)
  @ManyToOne
  // FIXME: a espera de creacion de la tabla Producto
  private Producto idProducto; 
  
  @Column(name = "calificacion", nullable = false)
  private Integer calificacion; 
  
 //TODO:  se debe revisar al crear las clases pendientes
  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">  

  public Integer getIdCalificacion() {
    return idCalificacion;
  }

  public void setIdCalificacion(Integer idCalificacion) {
    this.idCalificacion = idCalificacion;
  }

  public Producto getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Producto idProducto) {
    this.idProducto = idProducto;
  }

  public Integer getCalificacion() {
    return calificacion;
  }

  public void setCalificacion(Integer calificacion) {
    this.calificacion = calificacion;
  }
  //</editor-fold>  
 
  @Override
  public String toString(){
    return "Calificacion("
            + "id = " + idCalificacion + ", "
            + "idProducto = " + idProducto + ", "
            + "calificacion = " + calificacion + ", "
            + super.toString() 
            + ")";
  }  
  
}
