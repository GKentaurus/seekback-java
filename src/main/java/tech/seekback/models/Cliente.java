/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries(value = {
  @NamedQuery(name = "Cliente.getAll", query = "SELECT obj FROM Cliente obj")
})
public class Cliente implements Serializable {

  @Id
  @Column(name = "idCliente")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCliente;

  @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
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

  public Usuario getUsuario() {
    return idUsuario;
  }

  public void setUsuario(Usuario idUsuario) {
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
    return "CategoriasProducto("
            + "id = " + idCliente + ", "
            + "idUsuario = " + idUsuario + ", "
            + timestamps.toString()
            + ")";
  }

}
