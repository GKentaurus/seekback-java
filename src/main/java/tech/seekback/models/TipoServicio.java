package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.util.Objects;

/**
 * Definición del modelo "TipoServicio"
 *
 * @author veron
 */
@Entity
@Table(name = "tipo_servicio")
@NamedQueries(value = {
  @NamedQuery(name = "TipoServicio.getAll", query = "SELECT obj FROM TipoServicio obj WHERE obj.timestamps.deleted = false")
})
public class TipoServicio implements EntityTimestamp {

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
   * @return <code>timestamps</code> del tipo de servicio.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del tipo de servicio.
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
    final TipoServicio other = (TipoServicio) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "TipoServicio{"
      + "idTipoServicio=" + id + ", "
      + "nombreServicio=" + nombreServicio + ", "
      + timestamps.toString()
      + '}';
  }

}
