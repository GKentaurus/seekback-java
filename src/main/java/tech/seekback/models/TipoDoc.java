package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "TipoDoc"
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
   * @see Timestamps
   * @return <code>timestamps</code> del tipo de documento.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps del tipo de documento.
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
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
  public String toString() {
    return "TipoDoc("
            + "id = " + id + ", "
            + "nombreDocumento = " + nombreDocumento + ", "
            + timestamps.toString()
            + ")";
  }
}
