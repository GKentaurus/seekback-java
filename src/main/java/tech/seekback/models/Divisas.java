/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "divisas")
public class Divisas extends Timestamps {

  @Id
  @Column(name = "idDivisa",nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idDivisa;

  @Column(name = "nombre", length = 20, nullable = false)
  private String nombre;

  @Column(name = "sigla", length = 4, nullable = false, unique = true)
  private String sigla;

  //TODO:  se debe revisar al crear las clases pendientes
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
  //</editor-fold>

  @Override
  public String toString() {
    return "Cotizacion("
            + "id = " + idDivisa + ", "
            + "Nombre = " + nombre + ", "
            + "Sigla = " + sigla + ", "
            + super.toString()
            + ")";
  }

}
