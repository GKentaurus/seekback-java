/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Divisa;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class DivisasBuilder {

  private Divisa divisas;

  private DivisasBuilder() {
    this.divisas = new Divisa();
  }

  public static DivisasBuilder builder() {
    return new DivisasBuilder();
  }

  public DivisasBuilder id(Integer id) {
    this.divisas.setId(id);
    return this;
  }

  public DivisasBuilder nombre(String nombre) {
    this.divisas.setNombre(nombre);
    return this;
  }

  public DivisasBuilder sigla(String sigla) {
    this.divisas.setSigla(sigla);
    return this;
  }

  public DivisasBuilder timestamps(Timestamps timestamps) {
    this.divisas.setTimestamps(timestamps);
    return this;
  }

  public Divisa build() {
    return this.divisas;
  }
}
