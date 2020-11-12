package tech.seekback.models;

import java.util.Date;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "fidelizacion")
public class Fidelizacion extends Timestamps {

  @Id
  @Column(name = "idFidelizacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idFidelizacion;

  @Column(name = "idCalificacion", nullable = false)
  private Integer idCalificacion;

  @Column(name = "idFelicitacion", nullable = false)
  private Integer idFelicitacion;

  @Column(name = "idPQRS", nullable = false)
  private Integer idPQRS;

  @Column(name = "IdSoporte", nullable = false)
  private Integer IdSoporte;

  //TODO: como nombrar datos tipo Date
  @Column(name = "fechaInicio", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fechaInicio;

  //TODO: como nombrar datos tipo Date
  @Column(name = "fechaFin", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fechaFin;

  @Column(name = "comentario", length = 255, nullable = false)
  private String comentario;

  @Column(name = "idCliente", nullable = false)
  private Integer idCliente;

  @Column(name = "idAdministrador", nullable = false)
  private Integer idAdministrador;

  @Column(name = "idEmpleado", nullable = false)
  private Integer idEmpleado;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdFidelizacion() {
    return idFidelizacion;
  }

  public void setIdFidelizacion(Integer idFidelizacion) {
    this.idFidelizacion = idFidelizacion;
  }

  public Integer getIdCalificacion() {
    return idCalificacion;
  }

  public void setIdCalificacion(Integer idCalificacion) {
    this.idCalificacion = idCalificacion;
  }

  public Integer getIdFelicitacion() {
    return idFelicitacion;
  }

  public void setIdFelicitacion(Integer idFelicitacion) {
    this.idFelicitacion = idFelicitacion;
  }

  public Integer getIdPQRS() {
    return idPQRS;
  }

  public void setIdPQRS(Integer idPQRS) {
    this.idPQRS = idPQRS;
  }

  public Integer getIdSoporte() {
    return IdSoporte;
  }

  public void setIdSoporte(Integer IdSoporte) {
    this.IdSoporte = IdSoporte;
  }

  public String getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(String fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public String getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(String fechaFin) {
    this.fechaFin = fechaFin;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }

  public Integer getIdAdministrador() {
    return idAdministrador;
  }

  public void setIdAdministrador(Integer idAdministrador) {
    this.idAdministrador = idAdministrador;
  }

  public Integer getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Integer idEmpleado) {
    this.idEmpleado = idEmpleado;
  }
  //</editor-fold> 

  @Override
  public String toString() {
    return "Fidelizacion("
            + "id = " + idFidelizacion + ", "
            + "idCalificacion = " + idCalificacion + ", "
            + "idFelicitacion = " + idFelicitacion + ", "
            + "idPQRS = " + idPQRS + ", "
            + "IdSoporte = " + IdSoporte + ", "
            + "fechaInicio = " + fechaInicio + ", "
            + "fechaFin = " + fechaFin + ", "
            + "comentario = " + comentario + ", "
            + "idClient = " + idCliente + ", "
            + "idAdministrador = " + idAdministrador + ", "
            + "idEmpleado = " + idEmpleado + ", "
            + ")";
  }
}
