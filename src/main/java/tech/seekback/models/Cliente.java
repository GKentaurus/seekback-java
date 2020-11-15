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
@Table(name = "cliente")
// TODO: Confirmar si la herencia esta bien aplicada
@PrimaryKeyJoinColumn(name = "idCliente")
public class Cliente extends Usuario {

//  @Id
  @Column(name = "idCliente")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCliente;

  @Column(name = "idUsuario", nullable = false)
  @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
  @OneToOne(fetch = FetchType.EAGER)
  private Usuario idUsuario;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
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
    return "CategoriasProducto("
            + "id = " + idCliente + ", "
            + "idUsuario = " + idUsuario + ", "
            + timestamps.toString()
            + ")";
  }

}
