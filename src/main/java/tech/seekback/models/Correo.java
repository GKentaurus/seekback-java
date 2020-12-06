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
@Table(name = "correos")
@NamedQueries(value = {
  @NamedQuery(name = "Correos.getAll", query = "SELECT obj FROM Correo obj"),
  @NamedQuery(name = "Correos.getByCorreo", query = "SELECT obj FROM Correo obj WHERE obj.correoElectronico = :CorreoRec")
})
public class Correo implements Serializable {

  @Id
  @Column(name = "idCorreo")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idUsuario", nullable = false)
  private Usuario usuario;

  @Column(name = "correoElectronico", nullable = false, unique = true, length = 255)
  private String correoElectronico;

  @Column(name = "esPrincipal", nullable = false)
  private boolean esPrincipal;

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

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  public boolean getEsPrincipal() {
    return esPrincipal;
  }

  public void setEsPrincipal(Boolean esPrincipal) {
    this.esPrincipal = esPrincipal;
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
    hash = 47 * hash + Objects.hashCode(this.id);
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
    final Correo other = (Correo) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Correos("
            + "id = " + id + ", "
            + "usuario = " + usuario + ", "
            + "correo = " + correoElectronico + ", "
            + "principal = " + esPrincipal + ", "
            + timestamps.toString()
            + ")";
  }
}
