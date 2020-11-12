/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
@Entity
@Table(name = "ciudad")
public class Ciudad extends Timestamps {

  @Id
  @Column(name = "idCiudad")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCiudad;

  // TODO: Revisar relacion con la tabla "Departamento"
  @Column(name = "idDepartamento", nullable = false)
  @ManyToOne
  private Departamento idDepartamento;

  @Column(name = "nombreCiudad", length = 50, nullable = false)
  private String nombreCiudad;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdCiudad() {
    return idCiudad;
  }

  public void setIdCiudad(Integer idCiudad) {
    this.idCiudad = idCiudad;
  }

  public Departamento getIdDepartamento() {
    return idDepartamento;
  }

  public void setIdDepartamento(Departamento idDepartamento) {
    this.idDepartamento = idDepartamento;
  }

  public String getNombreCiudad() {
    return nombreCiudad;
  }

  public void setNombreCiudad(String nombreCiudad) {
    this.nombreCiudad = nombreCiudad;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Ciudad{" + "idCiudad = " + idCiudad + ", "
            + "idDepartamento = " + idDepartamento + ", "
            + "nombreCiudad = " + nombreCiudad + ", "
            + super.toString()
            + '}';
  }

}
