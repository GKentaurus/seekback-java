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
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TipoSolicitud getTipoSolicitud() {
    return tipoSolicitud;
  }

  public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
    this.tipoSolicitud = tipoSolicitud;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public EstadosFidelizacion getEstado() {
    return estado;
  }

  public void setEstado(EstadosFidelizacion estado) {
    this.estado = estado;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Administrador getAdministrador() {
    return administrador;
  }

  public void setAdministrador(Administrador administrador) {
    this.administrador = administrador;
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
