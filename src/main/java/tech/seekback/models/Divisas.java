/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "divisas")
public class Divisas implements Serializable {

  @Id
  @Column(name = "idDivisa")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idDivisa;

  @Column(name = "nombre", nullable = false, length = 20)
  private String nombre;

  @Column(name = "sigla", nullable = false, unique = true, length = 4)
  private String sigla;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdDivisa() {
    return idDivisa;
  }

  public void setIdDivisa(Integer idDivisa) {
    this.idDivisa = idDivisa;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Cotizacion("
            + "id = " + idDivisa + ", "
            + "Nombre = " + nombre + ", "
            + "Sigla = " + sigla + ", "
            + timestamps.toString()
            + ")";
  }

}
