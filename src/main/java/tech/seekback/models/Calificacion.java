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
 * Definición del modelo "Calificacion"
 *
 * @author danny
 */
@Entity
@Table(name = "calificacion")
@NamedQueries(value = {
  @NamedQuery(name = "Calificacion.getAll", query = "SELECT obj FROM Calificacion obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "Calificacion.getByIdProducto", query = "SELECT obj FROM Calificacion obj WHERE obj.producto.id = :idProducto AND obj.timestamps.deleted = false")
})
public class Calificacion implements Serializable {

  @Id
  @Column(name = "idCalificacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idCliente", nullable = false)
  private Cliente cliente;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idProducto", nullable = false)
  private Producto producto;

  @Column(name = "calificacion", nullable = false, length = 1)
  private Integer calificacion;

  @Column(name = "comentario", nullable = true, length = 255)
  private String comentario;

  @Column(name = "esAprobado", nullable = false)
  private Boolean esAprobado;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la calificación.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la calificación.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>producto</code> del objeto.
   *
   * @see Producto
   * @return <code>producto</code> de la calificación.
   */
  public Producto getProducto() {
    return producto;
  }

  /**
   * Asigna el valor del atributo <code>producto</code> del objeto.
   *
   * @see Producto
   * @param producto de la calificación.
   */
  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  /**
   * Retorna el valor del atributo <code>calificacion</code> del objeto.
   *
   * @return <code>calificacion</code> de la calificación.
   */
  public Integer getCalificacion() {
    return calificacion;
  }

  /**
   * Asigna el valor del atributo <code>calificacion</code> del objeto.
   *
   * @param calificacion de la calificación.
   */
  public void setCalificacion(Integer calificacion) {
    this.calificacion = calificacion;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> de la calificación.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps de la calificación.
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  /**
   * Retorna el valor del atributo <code>cliente</code> del objeto.
   *
   * @see Cliente
   * @return <code>cliente</code> de la calificación.
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo <code>cliente</code> del objeto.
   *
   * @see Cliente
   * @param cliente de la calificación.
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * Retorna el valor del atributo <code>comentario</code> del objeto.
   *
   * @return <code>comentario</code> de la calificación.
   */
  public String getComentario() {
    return comentario;
  }

  /**
   * Asigna el valor del atributo <code>comentario</code> del objeto.
   *
   * @param comentario de la calificación.
   */
  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  /**
   * Retorna el valor del atributo <code>esAprobado</code> del objeto.
   *
   * @return <code>esAprobado</code> de la calificación.
   */
  public Boolean getEsAprobado() {
    return esAprobado;
  }

  /**
   * Asigna el valor del atributo <code>esAprobado</code> del objeto.
   *
   * @param esAprobado de la calificación.
   */
  public void setEsAprobado(Boolean esAprobado) {
    this.esAprobado = esAprobado;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 61 * hash + Objects.hashCode(this.id);
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
    final Calificacion other = (Calificacion) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información
   * relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
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
