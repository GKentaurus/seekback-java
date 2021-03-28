package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.util.Objects;

/**
 * Definición del modelo "TipoDoc"
 *
 * @author veron
 */
@Entity
@Table(name = "tipo_doc")
@NamedQueries(value = {
  @NamedQuery(name = "TipoDoc.getAll", query = "SELECT obj FROM TipoDoc obj WHERE obj.timestamps.deleted = false")
})
public class TipoDoc implements EntityTimestamp {

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
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del tipo de documento.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del tipo de documento.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>sigla</code> del tipo de documento.
   */
  public String getSigla() {
    return sigla;
  }

  /**
   * Asigna el valor del atributo <code>sigla</code> del objeto.
   *
   * @param sigla del tipo de documento.
   */
  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  /**
   * Retorna el valor del atributo <code>nombreDocumento</code> del objeto.
   *
   * @return <code>nombreDocumento</code> del tipo de documento.
   */
  public String getNombreDocumento() {
    return nombreDocumento;
  }

  /**
   * Asigna el valor del atributo <code>nombreDocumento</code> del objeto.
   *
   * @param nombreDocumento del tipo de documento.
   */
  public void setNombreDocumento(String nombreDocumento) {
    this.nombreDocumento = nombreDocumento;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> del tipo de documento.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del tipo de documento.
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
    hash = 53 * hash + Objects.hashCode(this.id);
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
    final TipoDoc other = (TipoDoc) obj;
    return Objects.equals(this.id, other.id);
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
