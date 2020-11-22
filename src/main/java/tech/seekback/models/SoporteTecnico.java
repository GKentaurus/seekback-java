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
@Table(name = "soporte_tecnico")
public class SoporteTecnico implements Serializable {

  @Id
  @Column(name = "idSoporteTecnico")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idSoporteTecnico;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
  private Producto idProducto;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
  private Cliente idCliente;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado", nullable = true)
  private Empleado idEmpleado;

  @Column(name = "comentario", nullable = false, length = 255)
  private String comentario;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = false)
  private EstadosFidelizacion idEstado;

  @Column(name = "fechaRespuesta", nullable = true)
  @Temporal(TemporalType.DATE)
  private Date fechaRespuesta;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdSoporteTecnico() {
    return idSoporteTecnico;
  }

  public void setIdSoporteTecnico(Integer idSoporteTecnico) {
    this.idSoporteTecnico = idSoporteTecnico;
  }

  public Producto getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Producto idProducto) {
    this.idProducto = idProducto;
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

  public Empleado getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Empleado idEmpleado) {
    this.idEmpleado = idEmpleado;
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
    return "SoporteTecnico{"
            + "idSoporteTecnico = " + idSoporteTecnico + ", "
            + ", idProducto = " + idProducto + ", "
            + ", idCliente = " + idCliente + ", "
            + ", idEmpleado = " + idEmpleado + ", "
            + ", comentario = " + comentario + ", "
            + ", idEstado = " + idEstado + ", "
            + ", fechaRespuesta = " + fechaRespuesta + ", "
            + timestamps.toString()
            + '}';
  }
}
