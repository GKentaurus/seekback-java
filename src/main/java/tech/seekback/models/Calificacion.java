
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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
  private Usuario cliente;

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
   * @return <code>producto</code> de la calificación.
   * @see Producto
   */
  public Producto getProducto() {
    return producto;
  }

  /**
   * Asigna el valor del atributo <code>producto</code> del objeto.
   *
   * @param producto de la calificación.
   * @see Producto
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
   * @return <code>timestamps</code> de la calificación.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de la calificación.
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  /**
   * Retorna el valor del atributo <code>cliente</code> del objeto.
   *
   * @return <code>cliente</code> de la calificación.
   * @see Usuario
   */
  public Usuario getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo <code>cliente</code> del objeto.
   *
   * @param cliente de la calificación.
   * @see Usuario
   */
  public void setCliente(Usuario cliente) {
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
    return Objects.equals(this.id, other.id);
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
