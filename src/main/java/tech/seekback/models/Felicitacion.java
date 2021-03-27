package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Definición del modelo "Felicitacion"
 *
 * @author veron
 */
@Entity
@Table(name = "felicitacion")
@NamedQueries(value = {
  @NamedQuery(name = "Felicitacion.getAll", query = "SELECT obj FROM Felicitacion obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "Felicitacion.getAllCount", query = "SELECT COUNT(obj) FROM Felicitacion obj WHERE obj.timestamps.deleted = false")
})
public class Felicitacion implements Serializable {

  @Id
  @Column(name = "idFelicitacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idCliente", nullable = false)
  private Usuario cliente;

  @Column(name = "dirigidoA", nullable = false, length = 100)
  private String dirigidoA;

  @Column(name = "comentario", nullable = true, length = 255)
  private String comentario;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la felicitación.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la felicitación.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>dirigidoA</code> del objeto.
   *
   * @return <code>dirigidoA</code> de la felicitación.
   */
  public String getDirigidoA() {
    return dirigidoA;
  }

  /**
   * Asigna el valor del atributo <code>dirigidoA</code> del objeto.
   *
   * @param dirigidoA de la felicitación.
   */
  public void setDirigidoA(String dirigidoA) {
    this.dirigidoA = dirigidoA;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> de la felicitación.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de la felicitación.
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  /**
   * Retorna el valor del atributo <code>cliente</code> del objeto.
   *
   * @return <code>cliente</code> de la felicitación.
   * @see Usuario
   */
  public Usuario getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo <code>cliente</code> del objeto.
   *
   * @param cliente de la felicitación.
   * @see Usuario
   */
  public void setCliente(Usuario cliente) {
    this.cliente = cliente;
  }

  /**
   * Retorna el valor del atributo <code>comentario</code> del objeto.
   *
   * @return <code>comentario</code> de la felicitación.
   */
  public String getComentario() {
    return comentario;
  }

  /**
   * Asigna el valor del atributo <code>comentario</code> del objeto.
   *
   * @param comentario de la felicitación.
   */
  public void setComentario(String comentario) {
    this.comentario = comentario;
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
    final Felicitacion other = (Felicitacion) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Felicitacion("
      + "id = " + id + ", "
      + "cliente = " + cliente + ", "
      + "dirigidoA = " + dirigidoA + ", "
      + "comentario = " + comentario + ", "
      + timestamps.toString()
      + ")";
  }

}
