/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

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
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @Column(name = "observaciones", nullable = false, length = 255)
  private String observaciones;

  @Column(name = "idEstado", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idEstado")
  private EstadosAgenda idEstado;

  @Column(name = "idTipoServicio", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idTipoServicio")
  private TipoServicio idTipoServicio;

  @Column(name = "idCliente", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idCliente")
  private Cliente idCliente;

  @Column(name = "idEmpleado", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idEmpleado")
  private Empleado idEmpleado;

  @Column(name = "idAdministrador", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idAdministrador")
  private Administrador idAdministrador;

  @Embedded
  private Timestamps timestamps;

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
