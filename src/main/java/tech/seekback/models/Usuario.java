/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;
import static tech.seekback.tools.Encrypter.*;

/**
 *
 * @author camorenoc
 */
@MappedSuperclass
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

  @Id
  @Column(name = "idUsuario")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idUsuario;

  @Column(name = "primerNombre", nullable = false, length = 50)
  private String primerNombre;

  @Column(name = "otrosNombres", nullable = true, length = 50)
  private String otrosNombres;

  @Column(name = "primerApellido", nullable = false, length = 50)
  private String primerApellido;

  @Column(name = "otrosApellidos", nullable = true, length = 50)
  private String otrosApellidos;

  @Column(name = "tipoDoc", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "tipoDoc", referencedColumnName = "idTipoDoc")
  private TipoDoc tipoDoc;

  @Column(name = "numeroDoc", nullable = false, length = 50)
  private String numeroDoc;

  @Column(name = "contrasena", nullable = false, length = 255)
  private String contrasena;

  @Column(name = "rol", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "rol", referencedColumnName = "idRoles")
  private Roles rol;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getPrimerNombre() {
    return primerNombre;
  }

  public void setPrimerNombre(String primerNombre) {
    this.primerNombre = primerNombre;
  }

  public String getOtrosNombres() {
    return otrosNombres;
  }

  public void setOtrosNombres(String otrosNombres) {
    this.otrosNombres = otrosNombres;
  }

  public String getPrimerApellido() {
    return primerApellido;
  }

  public void setPrimerApellido(String primerApellido) {
    this.primerApellido = primerApellido;
  }

  public String getOtrosApellidos() {
    return otrosApellidos;
  }

  public void setOtrosApellidos(String otrosApellidos) {
    this.otrosApellidos = otrosApellidos;
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

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  public String getContrasena() {
    return contrasena;
  }

  // TODO: Probar método de encriptación
  public void setContrasena(String contrasena) throws NoSuchAlgorithmException, InvalidKeySpecException {
    this.contrasena = cryptoGetHash(contrasena);
  }

  public Boolean compareContrasena(String contrasena) throws NoSuchAlgorithmException, InvalidKeySpecException {
    return this.contrasena.equals(cryptoGetHash(contrasena));
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Usuario{"
            + "idUsuario = " + idUsuario + ", "
            + "pNombre = " + primerNombre + ", "
            + "sNombres = " + otrosNombres + ", "
            + "pApellido = " + primerApellido + ", "
            + "sApellido = " + otrosApellidos + ", "
            + "tipoDoc = " + tipoDoc + ", "
            + "numeroDoc = " + numeroDoc + ", "
            + "rol = " + rol + ", "
            + timestamps.toString()
            + '}';
  }
}
