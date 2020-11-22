package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "tipo_servicio")
@NamedQueries(value = {
  @NamedQuery(name = "TipoServicio.getAll", query = "SELECT obj FROM TipoServicio obj")
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
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombreServicio() {
    return nombreServicio;
  }

  public void setNombreServicio(String nombreServicio) {
    this.nombreServicio = nombreServicio;
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
    return "TipoServicio{"
            + "idTipoServicio=" + id + ", "
            + "nombreServicio=" + nombreServicio + ", "
            + timestamps.toString()
            + '}';
  }

}
