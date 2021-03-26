
package tech.seekback.builders;

import tech.seekback.models.Departamento;
import tech.seekback.models.Pais;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class DepartamentoBuilder {

  private final Departamento departamento;

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
