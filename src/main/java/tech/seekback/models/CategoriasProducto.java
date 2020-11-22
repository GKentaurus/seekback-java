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
@Table(name = "categorias_producto")
@NamedQueries(value = {
  @NamedQuery(name = "CategoriasProducto.getAll", query = "SELECT obj FROM CategoriasProducto obj")
})
public class CategoriasProducto implements Serializable {

  @Id
  @Column(name = "idCategoria")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCategoria;

  @Column(name = "nombreCategoria", nullable = false, length = 50)
  private String nombreCategoria;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Integer idCategoria) {
    this.idCategoria = idCategoria;
  }

  public String getNombreCategoria() {
    return nombreCategoria;
  }

  public void setNombreCategoria(String nombreCategoria) {
    this.nombreCategoria = nombreCategoria;
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
            + "id = " + idCategoria + ", "
            + "idProducto = " + nombreCategoria + ", "
            + timestamps.toString()
            + ")";
  }

}
