package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
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
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombrePais() {
    return nombrePais;
  }

  public void setNombrePais(String nombrePais) {
    this.nombrePais = nombrePais;
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
    return "Pais("
            + "id = " + id + ", "
            + "nombrePais = " + nombrePais + ", "
            + timestamps.toString()
            + ")";
  }
}
