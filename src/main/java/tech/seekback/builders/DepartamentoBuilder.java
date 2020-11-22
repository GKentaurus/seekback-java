/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Departamento;
import tech.seekback.models.Pais;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class DepartamentoBuilder {

  private Departamento departamento;

  private DepartamentoBuilder() {
    this.departamento = new Departamento();
  }

  public static DepartamentoBuilder builder() {
    return new DepartamentoBuilder();
  }

  public DepartamentoBuilder id(Integer id) {
    this.departamento.setId(id);
    return this;
  }

  public DepartamentoBuilder pais(Pais pais) {
    this.departamento.setPais(pais);
    return this;
  }

  public DepartamentoBuilder nombreDepartamento(String nombreDepartameto) {
    this.departamento.setNombreDepartamento(nombreDepartameto);
    return this;
  }

  public DepartamentoBuilder timestamps(Timestamps timestamps) {
    this.departamento.setTimestamps(timestamps);
    return this;
  }

  public Departamento build() {
    return this.departamento;
  }

}
