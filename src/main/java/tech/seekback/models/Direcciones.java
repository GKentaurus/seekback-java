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
@Table(name = "direcciones")
public class Direcciones implements Serializable {

  @Id
  @Column(name = "idDirecciones")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idDirecciones;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idRegistro", referencedColumnName = "idUsuario", nullable = false)
  private Usuario idRegistro;

  @Column(name = "pseudonimo", nullable = false, length = 30)
  private String pseudonimo;

  @Column(name = "direccion", nullable = false, length = 100)
  private String direccion;

  @Column(name = "telefono", nullable = false, length = 20)
  private String telefono;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "localizacion", referencedColumnName = "idCiudad", nullable = false)
  private Ciudad localizacion;

  @Embedded
  private Timestamps timestamps;

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

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
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
            + timestamps.toString()
            + '}';
  }

}
