/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;
/**
 *
 * @author danny
 */
@Entity
@Table(name="agenda")
public class Agenda extends Timestamps{

  @Id
  @Column(name="idAgenda")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idAgenda;
  
  @Column(name="fecha", nullable = false)
  private String fecha;
  
  @Column(name="observaciones", nullable = false)
  private String observaciones;
  
  // TODO: Revisar relación con la tabla "EstadoAgenda"
  @Column(name = "idEstado", nullable = false)
  @ManyToOne
  // FIXME: a espera de creacion de clase EstadoAgenda
  private EstadoAgenda idEstado; 
  
  // TODO: Revisar relación con la tabla "TipoServicio"
  @Column(name = "idTipoServicio", nullable = false)
  @ManyToOne
  // FIXME: a espera de creacion de clase TipoServicio
  private TipoServicio idTipoServicio; 
  
  // TODO: Revisar relación con la tabla "Usuario"
  @Column(name = "idCliente", nullable = false)
  @ManyToOne
  // FIXME: a espera de creacion de clase Cliente
  private Cliente idCliente; 
  
  // TODO: Revisar relación con la tabla "Empleado"
  @Column(name = "idEmpleado", nullable = false)
  @ManyToOne
  // FIXME: a espera de creacion de clase Empleado
  private Empleado idEmpleado; 
  
  // TODO: Revisar relación con la tabla "Administrador"
  @Column(name = "idAdministrador", nullable = false)
  @ManyToOne
  private Administrador idAdministrador; 

 //TODO:  se debe revisar al crear las clases pendientes
  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdAgenda() {
    return idAgenda;
  }

  public void setIdAgenda(Integer idAgenda) {
    this.idAgenda = idAgenda;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public EstadoAgenda getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(EstadoAgenda idEstado) {
    this.idEstado = idEstado;
  }

  public TipoServicio getIdTipoServicio() {
    return idTipoServicio;
  }

  public void setIdTipoServicio(TipoServicio idTipoServicio) {
    this.idTipoServicio = idTipoServicio;
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

  public Administrador getIdAdministrador() {
    return idAdministrador;
  }

  public void setIdAdministrador(Administrador idAdministrador) {
    this.idAdministrador = idAdministrador;
  }
  //</editor-fold>
  
    
  @Override
  public String toString(){
    return "Agenda("
            + "id = " + idAgenda + ", "
            + "fecha = " + fecha + ", "
            + "observaciones = " + observaciones + ", "
            + "idEstado = " + idEstado + ", "
            + "idTipoServicio = " + idTipoServicio + ", "
            + "idCliente = " + idCliente + ", "
            + "idEmpleado = " + idEmpleado + ", "
            + "idAdministrador = " + idAdministrador + ", "
            + super.toString() 
            + ")";
  }  
  
}
