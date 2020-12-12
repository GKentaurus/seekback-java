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
 * Definición del modelo "Divisa"
 *
 * @author danny
 */
@Entity
@Table(name = "divisas")
@NamedQueries(value = {
  @NamedQuery(name = "Divisas.getAll", query = "SELECT obj FROM Divisa obj WHERE obj.timestamps.deleted_at IS NULL")
})
public class Divisa implements Serializable {

  @Id
  @Column(name = "idDivisa")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombre", nullable = false, length = 20)
  private String nombre;

  @Column(name = "sigla", nullable = false, unique = true, length = 4)
  private String sigla;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la divisa.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la divisa.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>nombre</code> del objeto.
   *
   * @return <code>nombre</code> de la divisa.
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Asigna el valor del atributo <code>nombre</code> del objeto.
   *
   * @param nombre de la divisa.
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Retorna el valor del atributo <code>sigla</code> del objeto.
   *
   * @return <code>sigla</code> de la divisa.
   */
  public String getSigla() {
    return sigla;
  }

  /**
   * Asigna el valor del atributo <code>sigla</code> del objeto.
   *
   * @param sigla de la divisa.
   */
  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> de la divisa.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps de la divisa.
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
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
    final Divisa other = (Divisa) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  //</editor-fold>
  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información
   * relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
  public String toString() {
    return "Cotizacion("
            + "id = " + id + ", "
            + "Nombre = " + nombre + ", "
            + "Sigla = " + sigla + ", "
            + timestamps.toString()
            + ")";
  }

}
