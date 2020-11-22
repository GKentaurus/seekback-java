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
@NamedQueries(value = {
  @NamedQuery(name = "Cotizacion.getAll", query = "SELECT obj FROM Cotizacion obj")
})
public class Cotizacion implements Serializable {

  @Id
  @Column(name = "idCotizacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "requerimiento", nullable = false, length = 255)
  private String requerimiento;

  @Column(name = "fecha", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha;

  @Column(name = "vencimiento", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date vencimiento;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idTRM", nullable = false)
  private TRM trm;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idEstado", nullable = false)
  private EstadosCotizacion estado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idEmpleado", nullable = false)
  private Empleado empleado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idCliente", nullable = false)
  private Cliente cliente;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public TRM getTrm() {
    return trm;
  }

  public void setTrm(TRM trm) {
    this.trm = trm;
  }

  public EstadosCotizacion getEstado() {
    return estado;
  }

  public void setEstado(EstadosCotizacion estado) {
    this.estado = estado;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
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
            + "id = " + id + ", "
            + "requerimiento = " + requerimiento + ", "
            + "fecha = " + fecha + ", "
            + "fechaVencimiento = " + vencimiento + ", "
            + "trm = " + trm + ", "
            + "estado = " + estado + ", "
            + "empleado = " + empleado + ", "
            + "cliente = " + cliente + ", "
            + timestamps.toString()
            + ")";
  }

}
