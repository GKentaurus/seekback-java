
package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.util.Objects;

/**
 * Definición del modelo "EstadosFidelizacion"
 *
 * @author danny
 */
@Entity
@Table(name = "estados_fidelizacion")
@NamedQueries(value = {
  @NamedQuery(name = "EstadosFidelizacion.getAll", query = "SELECT obj FROM EstadosFidelizacion obj WHERE obj.timestamps.deleted = false")
})
public class EstadosFidelizacion implements EntityTimestamp {

  @Id
  @Column(name = "idEstado")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombreEstado", nullable = false, length = 30)
  private String nombreEstado;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del estado de fidelización.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del estado de fidelización.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>nombreEstado</code> del objeto.
   *
   * @return <code>nombreEstado</code> del estado de fidelización.
   */
  public String getNombreEstado() {
    return nombreEstado;
  }

  /**
   * Asigna el valor del atributo <code>nombreEstado</code> del objeto.
   *
   * @param nombreEstado del estado de fidelización.
   */
  public void setNombreEstado(String nombreEstado) {
    this.nombreEstado = nombreEstado;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> del estado de fidelización.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del estado de fidelización.
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 5;
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
    final EstadosFidelizacion other = (EstadosFidelizacion) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "EstadosFidelizacion("
      + "id = " + id + ", "
      + "nombreEstado = " + nombreEstado + ", "
      + timestamps.toString()
      + ")";
  }

}
