package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "TipoServicio"
 *
 * @author veron
 */
@Entity
@Table(name = "tipo_servicio")
@NamedQueries(value = {
  @NamedQuery(name = "TipoServicio.getAll", query = "SELECT obj FROM TipoServicio obj WHERE obj.timestamps.deleted_at IS NULL")
})
public class TipoServicio implements Serializable {

  @Id
  @Column(name = "idTipoServicio")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombreServicio", nullable = false, length = 30)
  private String nombreServicio;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del tipo de servicio.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del tipo de servicio.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>nombreServicio</code> del objeto.
   *
   * @return <code>nombreServicio</code> del tipo de servicio.
   */
  public String getNombreServicio() {
    return nombreServicio;
  }

  /**
   * Asigna el valor del atributo <code>nombreServicio</code> del objeto.
   *
   * @param nombreServicio del tipo de servicio.
   */
  public void setNombreServicio(String nombreServicio) {
    this.nombreServicio = nombreServicio;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> del tipo de servicio.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps del tipo de servicio.
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
    final TipoServicio other = (TipoServicio) obj;
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
    return "TipoServicio{"
            + "idTipoServicio=" + id + ", "
            + "nombreServicio=" + nombreServicio + ", "
            + timestamps.toString()
            + '}';
  }

}
