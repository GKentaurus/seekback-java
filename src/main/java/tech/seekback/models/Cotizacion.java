/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.util.Date;
import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;
/**
 *
 * @author danny
 */
@Entity
@Table(name = "correos")
public class Cotizacion extends Timestamps {

  @Id
  @Column(name = "idCotizacion",nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCotizacion;
  
  @Column(name = "requerimiento", nullable = false)
  private String requerimiento;
  
  @Column(name = "fecha", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fecha;
  
  @Column(name = "vencimiento", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date vencimiento;
  
  // TODO: Revisar relación con la tabla "TRM"
  @Column(name = "idTRM", nullable = false)
  @ManyToOne
  // FIXME: a espera de creaciond de clase TRM
  private TRM idTRM;
  
  // TODO: Revisar relación con la tabla "EstadosCotizacion"
  @Column(name = "idEstado", nullable = false)
  @ManyToOne
  private EstadosCotizacion idEstado;
  
  // TODO: Revisar relación con la tabla "Empleado"
  @Column(name = "idEmpleado", nullable = false)
  @ManyToOne
  private Empleado idEmpleado;
  
  // TODO: Revisar relación con la tabla "Cliente"
  @Column(name = "idCliente", nullable = false)
  @ManyToOne
  private Cliente idCliente;
  
  
 //TODO:  se debe revisar al crear las clases pendientes
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
  //</editor-fold>
  
  
  @Override
  public String toString(){
    return "Cotizacion("
            + "id = " + idCotizacion + ", "
            + "Requerimiento = " + requerimiento + ", "
            + "Fecha = " + fecha + ", "
            + "fVencimiento = " + vencimiento + ", "
            + "idTRM = " + idTRM + ", "
            + "idEstado = " + idEstado + ", "
            + "idEmpleado = " + idEmpleado + ", "
            + "idCliente = " + idCliente + ", "
            + super.toString() 
            + ")";
  }    
  
}
