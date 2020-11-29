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
 * @author camorenoc
 */
@Entity
@Table(name = "ciudad")
@NamedQueries(value = {
  @NamedQuery(name = "Ciudad.getAll", query = "SELECT obj FROM Ciudad obj"),
  @NamedQuery(name = "Ciudad.getByIdDepartamento", query = "SELECT obj FROM Ciudad obj WHERE obj.departamento.id = :DepartamentoId")
})
public class Ciudad implements Serializable {

  @Id
  @Column(name = "idCiudad")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idDepartamento", nullable = false)
  private Departamento departamento;

  @Column(name = "nombreCiudad", nullable = false, length = 50)
  private String nombreCiudad;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  public String getNombreCiudad() {
    return nombreCiudad;
  }

  public void setNombreCiudad(String nombreCiudad) {
    this.nombreCiudad = nombreCiudad;
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
    return "Ciudad{"
            + "id = " + id + ", "
            + "fepartamento = " + departamento + ", "
            + "nombreCiudad = " + nombreCiudad + ", "
            + timestamps.toString()
            + '}';
  }

}
