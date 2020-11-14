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
@Table(name = "cotizacion")
public class Cotizacion implements Serializable {

  @Id
  @Column(name = "idCotizacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCotizacion;

  @Column(name = "requerimiento", nullable = false, length = 255)
  private String requerimiento;

  @Column(name = "fecha", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @Column(name = "vencimiento", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date vencimiento;

  @Column(name = "idTRM", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idTRM")
  private TRM idTRM;

  @Column(name = "idEstado", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idEstado")
  private EstadosCotizacion idEstado;

  @Column(name = "idEmpleado", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idEmpleado")
  private Empleado idEmpleado;

  @Column(name = "idCliente", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idCliente")
  private Cliente idCliente;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdCotizacion() {
    return idCotizacion;
  }

  public void setIdCotizacion(Integer idCotizacion) {
    this.idCotizacion = idCotizacion;
  }

  public String getRequerimiento() {
    return requerimiento;
  }

  public void setRequerimiento(String requerimiento) {
    this.requerimiento = requerimiento;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Date getVencimiento() {
    return vencimiento;
  }

  public void setVencimiento(Date vencimiento) {
    this.vencimiento = vencimiento;
  }

  public TRM getIdTRM() {
    return idTRM;
  }

  public void setIdTRM(TRM idTRM) {
    this.idTRM = idTRM;
  }

  public EstadosCotizacion getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(EstadosCotizacion idEstado) {
    this.idEstado = idEstado;
  }

  public Empleado getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Empleado idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public Cliente getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Cliente idCliente) {
    this.idCliente = idCliente;
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
    return "Cotizacion("
            + "id = " + idCotizacion + ", "
            + "Requerimiento = " + requerimiento + ", "
            + "Fecha = " + fecha + ", "
            + "fVencimiento = " + vencimiento + ", "
            + "idTRM = " + idTRM + ", "
            + "idEstado = " + idEstado + ", "
            + "idEmpleado = " + idEmpleado + ", "
            + "idCliente = " + idCliente + ", "
            + timestamps.toString()
            + ")";
  }

}
