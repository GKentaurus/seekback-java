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
 * @author camorenoc
 */
@Entity
@Table(name = "direcciones")
@NamedQueries(value = {
  @NamedQuery(name = "Direcciones.getAll", query = "SELECT obj FROM Direccion obj")
})
public class Direccion implements Serializable {

  @Id
  @Column(name = "idDirecciones")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idRegistro", nullable = false)
  private Usuario usuario;

  @Column(name = "pseudonimo", nullable = false, length = 30)
  private String pseudonimo;

  @Column(name = "direccion", nullable = false, length = 100)
  private String direccion;

  @Column(name = "telefono", nullable = false, length = 20)
  private String telefono;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "localizacion", nullable = false)
  private Ciudad ciudad;

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

  public String getPseudonimo() {
    return pseudonimo;
  }

  public void setPseudonimo(String pseudonimo) {
    this.pseudonimo = pseudonimo;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public Ciudad getCiudad() {
    return ciudad;
  }

  public void setCiudad(Ciudad ciudad) {
    this.ciudad = ciudad;
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
    hash = 97 * hash + Objects.hashCode(this.id);
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
    final Direccion other = (Direccion) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Direcciones{"
            + "id = " + id + ", "
            + "usuario = " + usuario + ", "
            + "pseudonimo = " + pseudonimo + ", "
            + "direccion = " + direccion + ", "
            + "telefono = " + telefono + ", "
            + "ciudad = " + ciudad
            + timestamps.toString()
            + '}';
  }

}
