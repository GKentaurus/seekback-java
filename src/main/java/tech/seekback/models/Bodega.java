
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Definición del modelo "Bodega"
 *
 * @author danny
 */
@Entity
@Table(name = "bodega")
@NamedQueries(value = {
  @NamedQuery(name = "Bodega.getAll", query = "SELECT obj FROM Bodega obj WHERE obj.timestamps.deleted = false")
})
public class Bodega implements Serializable {

  @Id
  @Column(name = "idBodega")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombreBodega", nullable = false, length = 50)
  private String nombreBodega;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la bodega.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la bodega.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>nombreBodega</code> del objeto.
   *
   * @return <code>nombreBodega</code> de la bodega.
   */
  public String getNombreBodega() {
    return nombreBodega;
  }

  /**
   * Asigna el valor del atributo <code>nombreBodega</code> del objeto.
   *
   * @param nombreBodega de la bodega.
   */
  public void setNombreBodega(String nombreBodega) {
    this.nombreBodega = nombreBodega;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> de la bodega.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de la bodega.
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 3;
    hash = 79 * hash + Objects.hashCode(this.id);
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
    final Bodega other = (Bodega) obj;
    return Objects.equals(this.id, other.id);
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
    return "Bodega("
      + "id = " + id + ", "
      + "nombreBodega = " + nombreBodega + ", "
      + timestamps.toString()
      + ")";
  }

}
