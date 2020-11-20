/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import java.util.Date;
import tech.seekback.models.Divisas;
import tech.seekback.models.TRM;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class TRMBuilder {

  private TRM trm;

  private TRMBuilder() {
    this.trm = new TRM();
  }

  public static TRMBuilder builder() {
    return new TRMBuilder();
  }

  public TRMBuilder idTrm(Integer idTrm) {
    this.trm.setIdTrm(idTrm);
    return this;
  }

  public TRMBuilder idDivisa(Divisas idDivisa) {
    this.trm.setIdDivisa(idDivisa);
    return this;
  }

  public TRMBuilder fechaTRM(Date fechaTRM) {
    this.trm.setFechaTRM(fechaTRM);
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
