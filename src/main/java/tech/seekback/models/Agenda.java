/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "agenda")
@NamedQueries(value = {
  @NamedQuery(name = "Agenda.getAll", query = "SELECT obj FROM Agenda obj")
})
public class Agenda implements Serializable {

  @Id
  @Column(name = "idAgenda")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "fecha", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha;

  @Column(name = "observaciones", nullable = false, length = 255)
  private String observaciones;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idEstado", nullable = false)
  private EstadosAgenda estado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idTipoServicio", nullable = false)
  private TipoServicio tipoServicio;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idCliente", nullable = false)
  private Cliente cliente;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idEmpleado", nullable = true)
  private Empleado empleado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idAdministrador", nullable = true)
  private Administrador administrador;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public EstadosAgenda getEstado() {
    return estado;
  }

  public void setEstado(EstadosAgenda estado) {
    this.estado = estado;
  }

  public TipoServicio getTipoServicio() {
    return tipoServicio;
  }

  public void setTipoServicio(TipoServicio tipoServicio) {
    this.tipoServicio = tipoServicio;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  public Administrador getAdministrador() {
    return administrador;
  }

  public void setAdministrador(Administrador administrador) {
    this.administrador = administrador;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 3;
    hash = 71 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Agenda other = (Agenda) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Agenda("
            + "id = " + id + ", "
            + "fecha = " + fecha + ", "
            + "observaciones = " + observaciones + ", "
            + "estado = " + estado + ", "
            + "tipoServicio = " + tipoServicio + ", "
            + "cliente = " + cliente + ", "
            + "empleado = " + empleado + ", "
            + "administrador = " + administrador + ", "
            + timestamps.toString()
            + ")";
  }

}
