/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "empleado")
// TODO: Confirmar si la herencia esta bien aplicada
@PrimaryKeyJoinColumn(name = "idEmpleado")
public class Empleado extends Usuario {

//  @Id
  @Column(name = "idEmpleado")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEmpleado;

  @Column(name = "idUsuario", nullable = false)
//  @OneToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "idUsuario")
  private Usuario idUsuario;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Integer idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

//  public Usuario getIdUsuario() {
//    return idUsuario;
//  }
//
//  public void setIdUsuario(Usuario idUsuario) {
//    this.idUsuario = idUsuario;
//  }
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
