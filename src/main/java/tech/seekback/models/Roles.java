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
 * @author camorenoc
 */
@Entity
@Table(name = "roles")
@NamedQueries(value = {
  @NamedQuery(name = "Roles.getAll", query = "SELECT obj FROM Roles obj")
})
public class Roles implements Serializable {

  @Id
  @Column(name = "idRol")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idRol;

  @Column(name = "nombreRol", nullable = false, length = 50)
  private String nombreRol;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdRol() {
    return idRol;
  }

  public void setIdRol(Integer idRol) {
    this.idRol = idRol;
  }

  public String getNombreRol() {
    return nombreRol;
  }

  public void setNombreRol(String nombreRol) {
    this.nombreRol = nombreRol;
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
    return "Roles("
            + "id = " + idRol + ", "
            + "nombreRol = " + nombreRol + ", "
            + timestamps.toString()
            + ")";
  }
}
