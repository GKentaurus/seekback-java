
package tech.seekback.builders;

import tech.seekback.models.Divisa;
import tech.seekback.models.TRM;
import tech.seekback.models.templates.Timestamps;

import java.util.Date;

/**
 * @author gkentaurus
 */
public class TRMBuilder {

  private final TRM trm;

  private TRMBuilder() {
    this.trm = new TRM();
  }

  public static TRMBuilder builder() {
    return new TRMBuilder();
  }

  public TRMBuilder idTrm(Integer idTrm) {
    this.trm.setId(idTrm);
    return this;
  }

  public TRMBuilder divisa(Divisa divisa) {
    this.trm.setDivisa(divisa);
    return this;
  }

  public TRMBuilder fecha(Date fecha) {
    this.trm.setFecha(fecha);
    return this;
  }

  public TRMBuilder tasaCambio(Double tasaCambio) {
    this.trm.setTasaCambio(tasaCambio);
    return this;
  }

  public TRMBuilder timestamps(Timestamps timestamps) {
    this.trm.setTimestamps(timestamps);
    return this;
  }

  public TRM build() {
    return this.trm;
  }
}
