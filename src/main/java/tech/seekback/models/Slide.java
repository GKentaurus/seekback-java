/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
@Entity
public class Slide implements EntityTimestamp {

  @Id
  @Column(name = "idSlide")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "titulo", length = 50, nullable = false)
  private String titulo;

  @Column(name = "descripcion", length = 100)
  private String descripcion;

  @Column(name = "urlImagen", nullable = false)
  private String urlImagen;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold desc="Getters & Setters" defaultstate="collapsed">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getUrlImagen() {
    return urlImagen;
  }

  public void setUrlImagen(String urlImagen) {
    this.urlImagen = urlImagen;
  }

  @Override
  public Timestamps getTimestamps() {
    return timestamps;
  }

  @Override
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold desc="Equals & HashCode" defaultstate="collapsed">
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 97 * hash + Objects.hashCode(this.id);
    hash = 97 * hash + Objects.hashCode(this.titulo);
    hash = 97 * hash + Objects.hashCode(this.descripcion);
    hash = 97 * hash + Objects.hashCode(this.urlImagen);
    hash = 97 * hash + Objects.hashCode(this.timestamps);
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
    final Slide other = (Slide) obj;
    if (!Objects.equals(this.titulo, other.titulo)) {
      return false;
    }
    if (!Objects.equals(this.descripcion, other.descripcion)) {
      return false;
    }
    if (!Objects.equals(this.urlImagen, other.urlImagen)) {
      return false;
    }
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    if (!Objects.equals(this.timestamps, other.timestamps)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Slide{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", urlImagen=" + urlImagen + ", timestamps=" + timestamps + '}';
  }
}
