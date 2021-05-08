
package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.util.Objects;

/**
 * Definición del modelo "Divisa"
 *
 * @author danny
 */
@Entity
@Table(
  name = "divisas",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre", "sigla"})
  }
)
@NamedQueries(value = {
  @NamedQuery(name = "Divisa.getAll", query = "SELECT obj FROM Divisa obj WHERE obj.timestamps.deleted = false")
})
public class Divisa implements EntityTimestamp {

  @Id
  @Column(name = "idDivisa")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombre", nullable = false, length = 20)
  private String nombre;

  @Column(name = "sigla", nullable = false, unique = true, length = 4)
  private String sigla;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la divisa.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la divisa.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>nombre</code> del objeto.
   *
   * @return <code>nombre</code> de la divisa.
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Asigna el valor del atributo <code>nombre</code> del objeto.
   *
   * @param nombre de la divisa.
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Retorna el valor del atributo <code>sigla</code> del objeto.
   *
   * @return <code>sigla</code> de la divisa.
   */
  public String getSigla() {
    return sigla;
  }

  /**
   * Asigna el valor del atributo <code>sigla</code> del objeto.
   *
   * @param sigla de la divisa.
   */
  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> de la divisa.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de la divisa.
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
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
    final Divisa other = (Divisa) obj;
    return Objects.equals(this.id, other.id);
  }

  //</editor-fold>
  @Override
  public String toString() {
    return "Cotizacion("
      + "id = " + id + ", "
      + "Nombre = " + nombre + ", "
      + "Sigla = " + sigla + ", "
      + timestamps.toString()
      + ")";
  }

}
