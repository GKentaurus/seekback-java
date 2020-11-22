package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "tipo_doc")
@NamedQueries(value = {
  @NamedQuery(name = "TipoDoc.getAll", query = "SELECT obj FROM TipoDoc obj")
})
public class TipoDoc implements Serializable {

  @Id //esto es como la PK
  @Column(name = "idTipoDoc")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "sigla", nullable = false, length = 5)
  private String sigla;

  @Column(name = "nombreDocumento", nullable = false, length = 10)
  private String nombreDocumento;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  public String getNombreDocumento() {
    return nombreDocumento;
  }

  public void setNombreDocumento(String nombreDocumento) {
    this.nombreDocumento = nombreDocumento;
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
    return "TipoDoc("
            + "id = " + id + ", "
            + "nombreDocumento = " + nombreDocumento + ", "
            + timestamps.toString()
            + ")";
  }
}
