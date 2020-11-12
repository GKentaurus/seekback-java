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
@Table(name="bodega")
public class Bodega extends Timestamps{

  @Id
  @Column(name="idBodega")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idBodega;
  
  @Column(name="nombreBodega", nullable = false)
  private Integer nombreBodega;
  
  
  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  
  public Integer getIdBodega() {
    return idBodega;
  }

  public void setIdBodega(Integer idBodega) {
    this.idBodega = idBodega;
  }

  public Integer getNombreBodega() {
    return nombreBodega;
  }

  public void setNombreBodega(Integer nombreBodega) {
    this.nombreBodega = nombreBodega;
  }
  //</editor-fold>
  
  
  @Override
  public String toString(){
    return "Bodega("
            + "id = " + idBodega + ", "
            + "nombreBodega = " + nombreBodega + ", "
            + super.toString() 
            + ")";
  }  
  
}
