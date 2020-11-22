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
@Table(name = "administrador")
@NamedQueries(value = {
  @NamedQuery(name = "Administrador.getAll", query = "SELECT obj FROM Administrador obj")
})
public class Administrador implements Serializable {

  @Id
  @Column(name = "idAdministrador")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(name = "idUsuario", nullable = false)
  @OneToOne(fetch = FetchType.LAZY)
  private Usuario usuario;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
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
    return "Administrador("
            + "id = " + id + ", "
            + "usuario = " + usuario + ", "
            + timestamps.toString()
            + ")";
  }

}
