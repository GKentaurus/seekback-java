/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "divisas")
@NamedQueries(value = {
  @NamedQuery(name = "Divisas.getAll", query = "SELECT obj FROM Divisa obj")
})
public class Divisa implements Serializable {

  @Id
  @Column(name = "idDivisa")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombre", nullable = false, length = 20)
  private String nombre;

  @Column(name = "sigla", nullable = false, unique = true, length = 4)
  private String sigla;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Divisa other = (Divisa) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  //</editor-fold>
  @Override
  public String toString() {
    return "Cotizacion("
            + "id = " + id + ", "
            + "Nombre = " + nombre + ", "
            + "Sigla = " + sigla + ", "
            + timestamps.toString()
            + ")";
  }

}
