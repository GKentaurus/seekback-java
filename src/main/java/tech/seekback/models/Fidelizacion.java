package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "fidelizacion")
public class Fidelizacion implements Serializable {

  @Id
  @Column(name = "idFidelizacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idFidelizacion;

  @Column(name = "idCalificacion", nullable = false)
  @ManyToOne
  private Calificacion idCalificacion;

  @Column(name = "idFelicitacion", nullable = false)
  @ManyToOne
  private Felicitacion idFelicitacion;

  @Column(name = "idPQRS", nullable = false)
  @ManyToOne
  private PQRS idPQRS;

  @Column(name = "IdSoporte", nullable = false)
  @ManyToOne
  private SoporteTecnico IdSoporte;

  //TODO: como nombrar datos tipo Date
  @Column(name = "fechaInicio", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fechaInicio;

  //TODO: como nombrar datos tipo Date
  @Column(name = "fechaFin", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fechaFin;

  @Column(name = "comentario", nullable = false, length = 255)
  private String comentario;

  @Column(name = "idCliente", nullable = false)
  @ManyToOne
  private Cliente idCliente;

  @Column(name = "idAdministrador", nullable = false)
  @ManyToOne
  private Administrador idAdministrador;

  @Column(name = "idEmpleado", nullable = false)
  @ManyToOne
  private Empleado idEmpleado;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdFidelizacion() {
    return idFidelizacion;
  }

  public void setIdFidelizacion(Integer idFidelizacion) {
    this.idFidelizacion = idFidelizacion;
  }

  public Calificacion getIdCalificacion() {
    return idCalificacion;
  }

  public void setIdCalificacion(Calificacion idCalificacion) {
    this.idCalificacion = idCalificacion;
  }

  public Felicitacion getIdFelicitacion() {
    return idFelicitacion;
  }

  public void setIdFelicitacion(Felicitacion idFelicitacion) {
    this.idFelicitacion = idFelicitacion;
  }

  public PQRS getIdPQRS() {
    return idPQRS;
  }

  public void setIdPQRS(PQRS idPQRS) {
    this.idPQRS = idPQRS;
  }

  public SoporteTecnico getIdSoporte() {
    return IdSoporte;
  }

  public void setIdSoporte(SoporteTecnico IdSoporte) {
    this.IdSoporte = IdSoporte;
  }

  public Date getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public Date getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(Date fechaFin) {
    this.fechaFin = fechaFin;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
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

  public Empleado getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Empleado idEmpleado) {
    this.idEmpleado = idEmpleado;
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
            + timestamps.toString()
            + ")";
  }
}
