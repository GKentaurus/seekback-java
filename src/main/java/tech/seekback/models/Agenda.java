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
 * Definición del modelo "Agenda"
 *
 * @author danny
 */
@Entity
@Table(name = "agenda")
@NamedQueries(value = {
  @NamedQuery(name = "Agenda.getAll", query = "SELECT obj FROM Agenda obj WHERE obj.timestamps.deleted_at IS NULL")
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
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la agenda.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la agenda.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>fecha</code> del objeto.
   *
   * @return <code>fecha</code> de la agenda.
   */
  public Date getFecha() {
    return fecha;
  }

  /**
   * Asigna el valor del atributo <code>fecha</code> del objeto.
   *
   * @param fecha de la agenda.
   */
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  /**
   * Retorna el valor del atributo <code>observaciones</code> del objeto.
   *
   * @return <code>observaciones</code> de la agenda.
   */
  public String getObservaciones() {
    return observaciones;
  }

  /**
   * Asigna el valor del atributo <code>observaciones</code> del objeto.
   *
   * @param observaciones de la agenda.
   */
  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  /**
   * Retorna el valor del atributo <code>estado</code> del objeto.
   *
   * @see EstadosAgenda
   * @return <code>estado</code> de la agenda.
   */
  public EstadosAgenda getEstado() {
    return estado;
  }

  /**
   * Asigna el valor del atributo <code>estado</code> del objeto.
   *
   * @see EstadosAgenda
   * @param estado de la agenda.
   */
  public void setEstado(EstadosAgenda estado) {
    this.estado = estado;
  }

  /**
   * Retorna el valor del atributo <code>tipoServicio</code> del objeto.
   *
   * @see TipoServicio
   * @return <code>tipoServicio</code> de la agenda.
   */
  public TipoServicio getTipoServicio() {
    return tipoServicio;
  }

  /**
   * Asigna el valor del atributo <code>tipoServicio</code> del objeto.
   *
   * @see TipoServicio
   * @param tipoServicio de la agenda.
   */
  public void setTipoServicio(TipoServicio tipoServicio) {
    this.tipoServicio = tipoServicio;
  }

  /**
   * Retorna el valor del atributo <code>cliente</code> del objeto.
   *
   * @see Cliente
   * @return <code>cliente</code> de la agenda.
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo <code>cliente</code> del objeto.
   *
   * @see Cliente
   * @param cliente de la agenda.
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * Retorna el valor del atributo <code>empleado</code> del objeto.
   *
   * @see Empleado
   * @return <code>empleado</code> de la agenda.
   */
  public Empleado getEmpleado() {
    return empleado;
  }

  /**
   * Asigna el valor del atributo <code>empleado</code> del objeto.
   *
   * @see Empleado
   * @param empleado de la agenda.
   */
  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  /**
   * Retorna el valor del atributo <code>administrador</code> del objeto.
   *
   * @see Administrador
   * @return <code>administrador</code> de la agenda.
   */
  public Administrador getAdministrador() {
    return administrador;
  }

  /**
   * Asigna el valor del atributo <code>administrador</code> del objeto.
   *
   * @see Administrador
   * @param administrador de la agenda.
   */
  public void setAdministrador(Administrador administrador) {
    this.administrador = administrador;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> de la agenda.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps de la agenda.
   */
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
  /**
   * Retorna una cadena de caracteres de que resume toda la información
   * relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
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
