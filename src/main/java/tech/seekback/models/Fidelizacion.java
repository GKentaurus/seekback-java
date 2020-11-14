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

  @Column(name = "idCalificacion", nullable = true)
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idCalificacion")
  private Calificacion idCalificacion;

  @Column(name = "idFelicitacion", nullable = true)
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idFelicitacion")
  private Felicitacion idFelicitacion;

  @Column(name = "idPQRS", nullable = true)
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idPQRS")
  private PQRS idPQRS;

  @Column(name = "IdSoporte", nullable = true)
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IdSoporte")
  private SoporteTecnico IdSoporte;

  @Column(name = "fechaInicio", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;

  @Column(name = "fechaFin", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;

  @Column(name = "comentario", nullable = false, length = 255)
  private String comentario;

  @Column(name = "idCliente", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idCliente")
  private Cliente idCliente;

  @Column(name = "idAdministrador", nullable = true)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idAdministrador")
  private Administrador idAdministrador;

  @Column(name = "idEmpleado", nullable = true)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idEmpleado")
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
