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
@Table(name = "calificacion")
public class Calificacion implements Serializable {

  @Id
  @Column(name = "idCalificacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCalificacion;

  @Column(name = "idCliente", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idCliente")
  private Cliente idCliente;

  @Column(name = "idProducto", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idProducto")
  private Producto idProducto;

  @Column(name = "calificacion", nullable = false, length = 1)
  private Integer calificacion;

  @Column(name = "comentario", nullable = true, length = 255)
  private Integer comentario;

  @Column(name = "esAprobado", nullable = true, length = 255)
  private Boolean esAprobado;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdCalificacion() {
    return idCalificacion;
  }

  public void setIdCalificacion(Integer idCalificacion) {
    this.idCalificacion = idCalificacion;
  }

  public Producto getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Producto idProducto) {
    this.idProducto = idProducto;
  }

  public Integer getCalificacion() {
    return calificacion;
  }

  public void setCalificacion(Integer calificacion) {
    this.calificacion = calificacion;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  public Cliente getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Cliente idCliente) {
    this.idCliente = idCliente;
  }

  public Integer getComentario() {
    return comentario;
  }

  public void setComentario(Integer comentario) {
    this.comentario = comentario;
  }

  public Boolean getEsAprobado() {
    return esAprobado;
  }

  public void setEsAprobado(Boolean esAprobado) {
    this.esAprobado = esAprobado;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Calificacion("
            + "id = " + idCalificacion + ", "
            + "idCliente = " + idCliente + ", "
            + "idProducto = " + idProducto + ", "
            + "calificacion = " + calificacion + ", "
            + "comentario = " + comentario + ", "
            + "esAprobado = " + esAprobado + ", "
            + timestamps.toString()
            + ")";
  }

}
