/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "Ciudad"
 *
 * @author camorenoc
 */
@Entity
@Table(name = "ciudad")
@NamedQueries(value = {
  @NamedQuery(name = "Ciudad.getAll", query = "SELECT obj FROM Ciudad obj WHERE obj.timestamps.deleted_at IS NULL"),
  @NamedQuery(name = "Ciudad.getByIdDepartamento", query = "SELECT obj FROM Ciudad obj WHERE obj.departamento.id = :DepartamentoId")
})
public class Ciudad implements Serializable {

  @Id
  @Column(name = "idCiudad")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idDepartamento", nullable = false)
  private Departamento departamento;

  @Column(name = "nombreCiudad", nullable = false, length = 50)
  private String nombreCiudad;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la ciudad.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la ciudad.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>departamento</code> del objeto.
   *
   * @see Departamento
   * @return <code>departamento</code> de la ciudad.
   */
  public Departamento getDepartamento() {
    return departamento;
  }

  /**
   * Asigna el valor del atributo <code>departamento</code> del objeto.
   *
   * @see Departamento
   * @param departamento de la ciudad.
   */
  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  /**
   * Retorna el valor del atributo <code>nombreCiudad</code> del objeto.
   *
   * @return <code>nombreCiudad</code> de la ciudad.
   */
  public String getNombreCiudad() {
    return nombreCiudad;
  }

  /**
   * Asigna el valor del atributo <code>nombreCiudad</code> del objeto.
   *
   * @param nombreCiudad de la ciudad.
   */
  public void setNombreCiudad(String nombreCiudad) {
    this.nombreCiudad = nombreCiudad;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> de la ciudad.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps de la ciudad.
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 5;
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
    final Ciudad other = (Ciudad) obj;
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
    return "Ciudad{"
            + "id = " + id + ", "
            + "fepartamento = " + departamento + ", "
            + "nombreCiudad = " + nombreCiudad + ", "
            + timestamps.toString()
            + '}';
  }

}
