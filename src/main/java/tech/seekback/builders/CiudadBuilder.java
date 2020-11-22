/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Ciudad;
import tech.seekback.models.Departamento;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class CiudadBuilder {

  private Ciudad ciudad;

  private CiudadBuilder() {
    this.ciudad = new Ciudad();
  }

  public static CiudadBuilder builder() {
    return new CiudadBuilder();
  }

  public CiudadBuilder id(Integer id) {
    this.ciudad.setId(id);
    return this;
  }

  public CiudadBuilder departamento(Departamento departamento) {
    this.ciudad.setDepartamento(departamento);
    return this;
  }

  public CiudadBuilder nombreCiudad(String nombreCiudad) {
    this.ciudad.setNombreCiudad(nombreCiudad);
    return this;
  }

  public CiudadBuilder timestamps(Timestamps timestamps) {
    this.ciudad.setTimestamps(timestamps);
    return this;
  }

  public Ciudad build() {
    return this.ciudad;
  }

}
