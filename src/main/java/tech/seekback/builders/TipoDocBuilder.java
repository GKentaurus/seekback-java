
package tech.seekback.builders;

import tech.seekback.models.TipoDoc;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class TipoDocBuilder {

  private final TipoDoc tipoDoc;

  private TipoDocBuilder() {
    this.tipoDoc = new TipoDoc();
  }

  public static TipoDocBuilder builder() {
    return new TipoDocBuilder();
  }

  public TipoDocBuilder idTipoDoc(Integer idTipoDoc) {
    this.tipoDoc.setId(idTipoDoc);
    return this;
  }

  public TipoDocBuilder sigla(String sigla) {
    this.tipoDoc.setSigla(sigla);
    return this;
  }

  public TipoDocBuilder nombreDocumento(String nombreDocumento) {
    this.tipoDoc.setNombreDocumento(nombreDocumento);
    return this;
  }

  public TipoDocBuilder timestamps(Timestamps timestamps) {
    this.tipoDoc.setTimestamps(timestamps);
    return this;
  }

  public TipoDoc build() {
    return this.tipoDoc;
  }
}
