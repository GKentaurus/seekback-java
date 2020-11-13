package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "felicitacion")
public class Felicitacion implements Serializable {

  @Id
  @Column(name = "idFelicitacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idFelicitacion;

  @Column(name = "dirigidoA", nullable = false, length = 100)
  private String dirigidoA;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdFelicitacion() {
    return idFelicitacion;
  }

  public void setIdFelicitacion(Integer idFelicitacion) {
    this.idFelicitacion = idFelicitacion;
  }

  public String getDirigidoA() {
    return dirigidoA;
  }

  public void setDirigidoA(String dirigidoA) {
    this.dirigidoA = dirigidoA;
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
    return "Felicitacion("
            + "id = " + idFelicitacion + ", "
            + "dirigidoA = " + dirigidoA + ", "
            + timestamps.toString()
            + ")";
  }
}
