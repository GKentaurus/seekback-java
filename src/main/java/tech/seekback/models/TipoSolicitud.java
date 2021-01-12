package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "TipoSolicitud"
 *
 * @author veron
 */
@Entity
@Table(name = "tipo_solicitud")
@NamedQueries(value = {
  @NamedQuery(name = "TipoSolicitud.getAll", query = "SELECT obj FROM TipoSolicitud obj WHERE obj.timestamps.deleted = false")
})
public class TipoSolicitud implements Serializable {

  @Id
  @Column(name = "idTipoSolicitud")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombreSolicitud", nullable = false, length = 20)
  private String nombreSolicitud;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del tipo de solicitud.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del tipo de solicitud.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>nombreSolicitud</code> del objeto.
   *
   * @return <code>nombreSolicitud</code> del tipo de solicitud.
   */
  public String getNombreSolicitud() {
    return nombreSolicitud;
  }

  /**
   * Asigna el valor del atributo <code>nombreSolicitud</code> del objeto.
   *
   * @param nombreSolicitud del tipo de solicitud.
   */
  public void setNombreSolicitud(String nombreSolicitud) {
    this.nombreSolicitud = nombreSolicitud;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> del tipo de solicitud.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps del tipo de solicitud.
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.id);
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
    final TipoSolicitud other = (TipoSolicitud) obj;
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
    return "TipoSolicitud{"
            + "idTipoSolicitud=" + id + ", "
            + "nombreServicio=" + nombreSolicitud + ", "
            + timestamps.toString()
            + '}';
  }
}
