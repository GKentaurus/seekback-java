package tech.seekback.models;

import java.io.Serializable;
import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "tipo_doc")
public class TipoDoc implements Serializable {

  @Id //esto es como la PK
  @Column(name = "idTipoDoc")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTipoDoc;

  @Column(name = "sigla", nullable = false, length = 5)//relacion con las columnas
  private String sigla;

  @Column(name = "nombreDocumento", nullable = false, length = 10)
  private String nombreDocumento;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdTipoDoc() {
    return idTipoDoc;
  }

  public void setIdTipoDoc(Integer idTipoDoc) {
    this.idTipoDoc = idTipoDoc;
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
            + "id = " + idTipoDoc + ", "
            + "nombreDocumento = " + nombreDocumento + ", "
            + timestamps.toString()
            + ")";
  }
}
