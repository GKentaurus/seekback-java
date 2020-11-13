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
 * @author camorenoc
 */
@Entity
@Table(name = "direcciones")
public class Direcciones extends Timestamps {

  @Id
  @Column(name = "idDirecciones")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idDirecciones;

  // TODO: Revisar relacion con la tabla "Ciudad"
  @Column(name = "idRegistro", nullable = false)
  private Usuario idRegistro;

  @Column(name = "pseudonimo", length = 30, nullable = false)
  private String pseudonimo;

  @Column(name = "direccion", length = 100, nullable = false)
  private String direccion;

  @Column(name = "telefono", length = 20, nullable = false)
  private String telefono;

  @Column(name = "localizacion", nullable = false)
  @ManyToOne
  private Ciudad localizacion;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdDirecciones() {
    return idDirecciones;
  }

  public void setIdDirecciones(Integer idDirecciones) {
    this.idDirecciones = idDirecciones;
  }

  public Usuario getIdRegistro() {
    return idRegistro;
  }

  public void setIdRegistro(Usuario idRegistro) {
    this.idRegistro = idRegistro;
  }

  public String getPseudonimo() {
    return pseudonimo;
  }

  public void setPseudonimo(String pseudonimo) {
    this.pseudonimo = pseudonimo;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public Ciudad getLocalizacion() {
    return localizacion;
  }

  public void setLocalizacion(Ciudad localizacion) {
    this.localizacion = localizacion;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Direcciones{"
            + "idDirecciones = " + idDirecciones + ", "
            + "idRegistro = " + idRegistro + ", "
            + "pseudonimo = " + pseudonimo + ", "
            + "direccion = " + direccion + ", "
            + "telefono = " + telefono + ", "
            + "localizacion=" + localizacion
            + super.toString()
            + '}';
  }

}
