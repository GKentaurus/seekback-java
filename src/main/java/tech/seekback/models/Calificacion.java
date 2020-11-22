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
@NamedQueries(value = {
  @NamedQuery(name = "Calificacion.getAll", query = "SELECT obj FROM Calificacion obj")
})
public class Calificacion implements Serializable {

  @Id
  @Column(name = "idCalificacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idCliente", nullable = false)
  private Cliente cliente;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idProducto", nullable = false)
  private Producto producto;

  @Column(name = "calificacion", nullable = false, length = 1)
  private Integer calificacion;

  @Column(name = "comentario", nullable = true, length = 255)
  private Integer comentario;

  @Column(name = "esAprobado", nullable = true, length = 255)
  private Boolean esAprobado;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
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

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
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
            + "id = " + id + ", "
            + "cliente = " + cliente + ", "
            + "producto = " + producto + ", "
            + "calificacion = " + calificacion + ", "
            + "comentario = " + comentario + ", "
            + "esAprobado = " + esAprobado + ", "
            + timestamps.toString()
            + ")";
  }

}
