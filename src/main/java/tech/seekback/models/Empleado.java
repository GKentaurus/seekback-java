/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

  @Id
  @Column(name = "idEmpleado")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEmpleado;

  // TODO: Revisar relación con la tabla "Usuario"
  @Column(name = "idUsuario", nullable = false)
  @ManyToOne
  private Usuario idUsuario;

  @Embedded
  private Timestamps timestamps;

  //TODO:  se debe revisar al crear las clases pendientes
  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Integer idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public Usuario getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Usuario idUsuario) {
    this.idUsuario = idUsuario;
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
    return "DocumentoDetallado("
            + "id = " + idEmpleado + ", "
            + "idUsuario = " + idUsuario + ", "
            + timestamps.toString()
            + ")";
  }

}
