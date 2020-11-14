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
@Table(name = "bodega")
public class Bodega implements Serializable {

  @Id
  @Column(name = "idBodega")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idBodega;

  @Column(name = "nombreBodega", nullable = false, length = 50)
  private String nombreBodega;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdBodega() {
    return idBodega;
  }

  public void setIdBodega(Integer idBodega) {
    this.idBodega = idBodega;
  }

  public String getNombreBodega() {
    return nombreBodega;
  }

  public void setNombreBodega(String nombreBodega) {
    this.nombreBodega = nombreBodega;
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
    return "Bodega("
            + "id = " + idBodega + ", "
            + "nombreBodega = " + nombreBodega + ", "
            + timestamps.toString()
            + ")";
  }

}
