package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "tipo_solicitud")
@NamedQueries(value = {
  @NamedQuery(name = "TipoSolicitud.getAll", query = "SELECT obj FROM TipoSolicitud obj WHERE obj.timestamps.deleted_at IS NULL")
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
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombreSolicitud() {
    return nombreSolicitud;
  }

  public void setNombreSolicitud(String nombreSolicitud) {
    this.nombreSolicitud = nombreSolicitud;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

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
  public String toString() {
    return "TipoSolicitud{"
            + "idTipoSolicitud=" + id + ", "
            + "nombreServicio=" + nombreSolicitud + ", "
            + timestamps.toString()
            + '}';
  }
}
