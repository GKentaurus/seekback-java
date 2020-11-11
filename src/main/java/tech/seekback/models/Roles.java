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
 * @author camorenoc
 */
@Entity
@Table(name = "roles")
public class Roles extends Timestamps {

  @Id
  @Column(name = "idRol")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idRol;

  @Column(name = "nombreRol", length = 50, nullable = false)
  private String nombreRol;

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
  //</editor-fold>

  @Override
  public String toString() {
    return "Rol("
            + "id = " + idRol + ", "
            + "nombreRol = " + nombreRol + ", "
            + super.toString() 
            + ")";
  }
}
