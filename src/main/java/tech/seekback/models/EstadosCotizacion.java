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
@Table(name = "estados_cotizacion")
public class EstadosCotizacion extends Timestamps {

  @Id
  @Column(name = "idEstado",nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEstadoCotizacion;

  @Column(name = "nombreEstado", nullable = false)
  private String nombreEstado;

  //TODO:  se debe revisar al crear las clases pendientes
  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdEstadoCotizacion() {
    return idEstadoCotizacion;
  }

  public void setIdEstadoCotizacion(Integer idEstadoCotizacion) {
    this.idEstadoCotizacion = idEstadoCotizacion;
  }

  public String getNombreEstado() {
    return nombreEstado;
  }

  public void setNombreEstado(String nombreEstado) {
    this.nombreEstado = nombreEstado;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "EstadosCotizacion("
            + "id = " + idEstadoCotizacion + ", "
            + "nombreEstado = " + nombreEstado + ", "
            + super.toString()
            + ")";
  }

}
