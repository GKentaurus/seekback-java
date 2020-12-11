package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "Pais"
 *
 * @author veron
 */
@Entity
@Table(name = "pais")
@NamedQueries(value = {
  @NamedQuery(name = "Pais.getAll", query = "SELECT obj FROM Pais obj"),
  @NamedQuery(name = "Pais.getOne", query = "SELECT obj FROM Pais obj WHERE obj.id = :idPais")
})
public class Pais implements Serializable {

  @Id //esto es como la PK
  @Column(name = "idPais")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombrePais", nullable = false, length = 30)
  private String nombrePais;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del país.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del país.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>nombrePais</code> del objeto.
   *
   * @return <code>nombrePais</code> del país.
   */
  public String getNombrePais() {
    return nombrePais;
  }

  /**
   * Asigna el valor del atributo <code>nombrePais</code> del objeto.
   *
   * @param nombrePais del país.
   */
  public void setNombrePais(String nombrePais) {
    this.nombrePais = nombrePais;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> del país.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps del país.
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 3;
    hash = 13 * hash + Objects.hashCode(this.id);
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
    final Pais other = (Pais) obj;
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
    return "Pais("
            + "id = " + id + ", "
            + "nombrePais = " + nombrePais + ", "
            + timestamps.toString()
            + ")";
  }
}
