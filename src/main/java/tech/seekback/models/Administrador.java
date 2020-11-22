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
  private Integer idAdministrador;

  @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
  @OneToOne(fetch = FetchType.EAGER)
  private Usuario idUsuario;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdAdministrador() {
    return idAdministrador;
  }

  public void setIdAdministrador(Integer idAdministrador) {
    this.idAdministrador = idAdministrador;
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
    return "Administrador("
            + "id = " + idAdministrador + ", "
            + "idUsuario = " + idUsuario + ", "
            + timestamps.toString()
            + ")";
  }

}
