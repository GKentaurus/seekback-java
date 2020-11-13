/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "calificacion")
public class Calificacion implements Serializable {

  @Id
  @Column(name = "idCalificacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCalificacion;

  // TODO: revisar relacion con la tabla  Producto
  @Column(name = "idProducto", nullable = false)
  @ManyToOne
  private Producto idProducto;

  @Column(name = "calificacion", nullable = false, length = 1)
  private Integer calificacion;

  @Embedded
  private Timestamps timestamps;

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

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Calificacion("
            + "id = " + idCalificacion + ", "
            + "idProducto = " + idProducto + ", "
            + "calificacion = " + calificacion + ", "
            + timestamps.toString()
            + ")";
  }

}
