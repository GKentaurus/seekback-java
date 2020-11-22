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
  private Integer idPQRS;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idTipoSolicitud", referencedColumnName = "idTipoSolicitud", nullable = false)
  private TipoSolicitud idTipoSolicitud;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
  private Cliente idCliente;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idAdministrador", referencedColumnName = "idAdministrador", nullable = false)
  private Administrador idAdministrador;

  @Column(name = "area", nullable = false, length = 100)
  private String area;

  @Column(name = "comentario", nullable = false, length = 255)
  private String comentario;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = false)
  private EstadosFidelizacion idEstado;

  @Column(name = "fechaRespuesta", nullable = true)
  private Date fechaRespuesta;

  @Embedded
  private Timestamps timestamps;

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

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  public Cliente getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Cliente idCliente) {
    this.idCliente = idCliente;
  }

  public Administrador getIdAdministrador() {
    return idAdministrador;
  }

  public void setIdAdministrador(Administrador idAdministrador) {
    this.idAdministrador = idAdministrador;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public Date getFechaRespuesta() {
    return fechaRespuesta;
  }

  public void setFechaRespuesta(Date fechaRespuesta) {
    this.fechaRespuesta = fechaRespuesta;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "PQRS{"
            + "idPQRS = " + idPQRS + ", "
            + "idTipoSolicitud = " + idTipoSolicitud + ", "
            + "idCliente = " + idCliente + ", "
            + "idAdministrador = " + idAdministrador + ", "
            + "area = " + area + ", "
            + "comentario = " + comentario + ", "
            + "idEstado = " + idEstado
            + "fechaRespuesta = " + fechaRespuesta
            + timestamps.toString()
            + '}';
  }
}
