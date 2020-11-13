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
@Table(name = "usuario")
public class Usuario extends Timestamps {

  @Id
  @Column(name = "idUsuario")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idUsuario;

  @Column(name = "pNombre", length = 50, nullable = false)
  private String pNombre;

  @Column(name = "sNombres", length = 50, nullable = true)
  private String sNombres;

  @Column(name = "pApellido", length = 50, nullable = false)
  private String pApellido;

  @Column(name = "sApellido", length = 50, nullable = true)
  private String sApellido;

  // TODO: Revisar relación con la tabla "tipo_doc"
  @Column(name = "tipoDoc", nullable = false)
  private TipoDoc tipoDoc;

  @Column(name = "numeroDoc", length = 50, nullable = false)
  private String numeroDoc;

  // Campo VARCHAR sin límite (String largo al momento de encriptar)
  @Column(name = "contrasena", nullable = false)
  private String contrasena;

  // TODO: Revisar relación con la tabla "roles"
  @Column(name = "rol", nullable = false)
  @ManyToOne
  private Roles rol;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getpNombre() {
    return pNombre;
  }

  public void setpNombre(String pNombre) {
    this.pNombre = pNombre;
  }

  public String getsNombres() {
    return sNombres;
  }

  public void setsNombres(String sNombres) {
    this.sNombres = sNombres;
  }

  public String getpApellido() {
    return pApellido;
  }

  public void setpApellido(String pApellido) {
    this.pApellido = pApellido;
  }

  public String getsApellido() {
    return sApellido;
  }

  public void setsApellido(String sApellido) {
    this.sApellido = sApellido;
  }

  public TipoDoc getTipoDoc() {
    return tipoDoc;
  }

  public void setTipoDoc(TipoDoc tipoDoc) {
    this.tipoDoc = tipoDoc;
  }

  public String getNumeroDoc() {
    return numeroDoc;
  }

  public void setNumeroDoc(String numeroDoc) {
    this.numeroDoc = numeroDoc;
  }

  public Roles getRol() {
    return rol;
  }

  public void setRol(Roles rol) {
    this.rol = rol;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Usuario{"
            + "idUsuario = " + idUsuario + ", "
            + "pNombre = " + pNombre + ", "
            + "sNombres = " + sNombres + ", "
            + "pApellido = " + pApellido + ", "
            + "sApellido = " + sApellido + ", "
            + "tipoDoc = " + tipoDoc + ", "
            + "numeroDoc = " + numeroDoc + ", "
            + super.toString()
            + "rol = " + rol
            + '}';
  }
}
