/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "agenda")
public class Agenda implements Serializable {

  @Id
  @Column(name = "idAgenda")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idAgenda;

  @Column(name = "fecha", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fecha;

  @Column(name = "observaciones", nullable = false, length = 255)
  private String observaciones;

  // TODO: Revisar relación con la tabla "EstadosAgenda"
  @Column(name = "idEstado", nullable = false)
  @ManyToOne
  private EstadosAgenda idEstado;

  // TODO: Revisar relación con la tabla "TipoServicio"
  @Column(name = "idTipoServicio", nullable = false)
  @ManyToOne
  private TipoServicio idTipoServicio;

  // TODO: Revisar relación con la tabla "Usuario"
  @Column(name = "idCliente", nullable = false)
  @ManyToOne
  private Cliente idCliente;

  // TODO: Revisar relación con la tabla "Empleado"
  @Column(name = "idEmpleado", nullable = false)
  @ManyToOne
  private Empleado idEmpleado;

  // TODO: Revisar relación con la tabla "Administrador"
  @Column(name = "idAdministrador", nullable = false)
  @ManyToOne
  private Administrador idAdministrador;

  @Embedded
  private Timestamps timestamps;

  //TODO:  se debe revisar al crear las clases pendientes
  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdAgenda() {
    return idAgenda;
  }

  public void setIdAgenda(Integer idAgenda) {
    this.idAgenda = idAgenda;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public EstadosAgenda getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(EstadosAgenda idEstado) {
    this.idEstado = idEstado;
  }

  public TipoServicio getIdTipoServicio() {
    return idTipoServicio;
  }

  public void setIdTipoServicio(TipoServicio idTipoServicio) {
    this.idTipoServicio = idTipoServicio;
  }

  public Cliente getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Cliente idCliente) {
    this.idCliente = idCliente;
  }

  public Empleado getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Empleado idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public Administrador getIdAdministrador() {
    return idAdministrador;
  }

  public void setIdAdministrador(Administrador idAdministrador) {
    this.idAdministrador = idAdministrador;
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
    return "Agenda("
            + "id = " + idAgenda + ", "
            + "fecha = " + fecha + ", "
            + "observaciones = " + observaciones + ", "
            + "idEstado = " + idEstado + ", "
            + "idTipoServicio = " + idTipoServicio + ", "
            + "idCliente = " + idCliente + ", "
            + "idEmpleado = " + idEmpleado + ", "
            + "idAdministrador = " + idAdministrador + ", "
            + timestamps.toString()
            + ")";
  }

}
