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
 * Definición del modelo "PQRS"
 *
 * @author camorenoc
 */
@Entity
@Table(name = "pqrs")
@NamedQueries(value = {
  @NamedQuery(name = "PQRS.getAll", query = "SELECT obj FROM PQRS obj")
})
public class PQRS implements Serializable {

  @Id
  @Column(name = "idPQRS")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idTipoSolicitud", nullable = false)
  private TipoSolicitud tipoSolicitud;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idCliente", nullable = false)
  private Cliente cliente;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idAdministrador", nullable = false)
  private Administrador administrador;

  @Column(name = "area", nullable = false, length = 100)
  private String area;

  @Column(name = "comentario", nullable = false, length = 255)
  private String comentario;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idEstado", nullable = false)
  private EstadosFidelizacion estado;

  @Column(name = "fechaRespuesta", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaRespuesta;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del PQRS.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del PQRS.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>tipoSolicitud</code> del objeto.
   *
   * @see TipoSolicitud
   * @return <code>tipoSolicitud</code> del PQRS.
   */
  public TipoSolicitud getTipoSolicitud() {
    return tipoSolicitud;
  }

  /**
   * Asigna el valor del atributo <code>tipoSolicitud</code> del objeto.
   *
   * @see TipoSolicitud
   * @param tipoSolicitud del PQRS.
   */
  public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
    this.tipoSolicitud = tipoSolicitud;
  }

  /**
   * Retorna el valor del atributo <code>area</code> del objeto.
   *
   * @return <code>area</code> del PQRS.
   */
  public String getArea() {
    return area;
  }

  /**
   * Asigna el valor del atributo <code>area</code> del objeto.
   *
   * @param area del PQRS.
   */
  public void setArea(String area) {
    this.area = area;
  }

  /**
   * Retorna el valor del atributo <code>estado</code> del objeto.
   *
   * @see EstadosFidelizacion
   * @return <code>estado</code> del PQRS.
   */
  public EstadosFidelizacion getEstado() {
    return estado;
  }

  /**
   * Asigna el valor del atributo <code>estado</code> del objeto.
   *
   * @see EstadosFidelizacion
   * @param estado del PQRS.
   */
  public void setEstado(EstadosFidelizacion estado) {
    this.estado = estado;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> del PQRS.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps del PQRS.
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  /**
   * Retorna el valor del atributo <code>cliente</code> del objeto.
   *
   * @see Cliente
   * @return <code>cliente</code> del PQRS.
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo <code>cliente</code> del objeto.
   *
   * @see Cliente
   * @param cliente del PQRS.
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * Retorna el valor del atributo <code>administrador</code> del objeto.
   *
   * @see Administrador
   * @return <code>administrador</code> del PQRS.
   */
  public Administrador getAdministrador() {
    return administrador;
  }

  /**
   * Asigna el valor del atributo <code>administrador</code> del objeto.
   *
   * @see Administrador
   * @param administrador del PQRS.
   */
  public void setAdministrador(Administrador administrador) {
    this.administrador = administrador;
  }

  /**
   * Retorna el valor del atributo <code>comentario</code> del objeto.
   *
   * @return <code>comentario</code> del PQRS.
   */
  public String getComentario() {
    return comentario;
  }

  /**
   * Asigna el valor del atributo <code>comentario</code> del objeto.
   *
   * @param comentario del PQRS.
   */
  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  /**
   * Retorna el valor del atributo <code>fechaRespuesta</code> del objeto.
   *
   * @return <code>fechaRespuesta</code> del PQRS.
   */
  public Date getFechaRespuesta() {
    return fechaRespuesta;
  }

  /**
   * Asigna el valor del atributo <code>fechaRespuesta</code> del objeto.
   *
   * @param fechaRespuesta del PQRS.
   */
  public void setFechaRespuesta(Date fechaRespuesta) {
    this.fechaRespuesta = fechaRespuesta;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 37 * hash + Objects.hashCode(this.id);
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
    final PQRS other = (PQRS) obj;
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
    return "PQRS{"
            + "id = " + id + ", "
            + "tipoSolicitud = " + tipoSolicitud + ", "
            + "cliente = " + cliente + ", "
            + "administrador = " + administrador + ", "
            + "area = " + area + ", "
            + "comentario = " + comentario + ", "
            + "estado = " + estado
            + "fechaRespuesta = " + fechaRespuesta
            + timestamps.toString()
            + '}';
  }
}
