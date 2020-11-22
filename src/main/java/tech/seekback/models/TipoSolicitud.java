package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "tipo_solicitud")
@NamedQueries(value = {
  @NamedQuery(name = "TipoSolicitud.getAll", query = "SELECT obj FROM TipoSolicitud obj")
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

  @Override
  public String toString() {
    return "TipoSolicitud{"
            + "idTipoSolicitud=" + id + ", "
            + "nombreServicio=" + nombreSolicitud + ", "
            + timestamps.toString()
            + '}';
  }
}
