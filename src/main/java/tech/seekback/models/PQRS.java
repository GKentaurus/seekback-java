/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
@Entity
@Table(name = "pqrs")
public class PQRS  extends Timestamps {
  
  @Id
  @Column(name = "idPQRS")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPQRS;
  
  @Column(name = "idTipoSolicitud", nullable = false)
  @ManyToOne
  private TipoSolicitud idTipoSolicitud;
  
  @Column(name = "area", nullable = false, length = 100)
  private String area;
  
  @Column(name = "idEstado", nullable = false)
  @ManyToOne
  private EstadosFidelizacion idEstado;
  
  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">

  public Integer getIdPQRS() {
    return idPQRS;
  }

  public void setIdPQRS(Integer idPQRS) {
    this.idPQRS = idPQRS;
  }

  public TipoSolicitud getIdTipoSolicitud() {
    return idTipoSolicitud;
  }

  public void setIdTipoSolicitud(TipoSolicitud idTipoSolicitud) {
    this.idTipoSolicitud = idTipoSolicitud;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public EstadosFidelizacion getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(EstadosFidelizacion idEstado) {
    this.idEstado = idEstado;
  }
   //</editor-fold>

  @Override
  public String toString() {
    return "PQRS{" 
            + "idPQRS = " + idPQRS + ", "
            + "idTipoSolicitud = " + idTipoSolicitud + ", "
            + "area = " + area + ", "
            + "idEstado = " + idEstado 
            + super.toString()
            + '}';
  }  
}
