/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.PQRS;

/**
 *
 * @author camorenoc
 */
public class PQRSBuilder {

  private PQRS pqrs;

  private PQRSBuilder() {
    this.pqrs = new PQRS();
  }

  public static PQRSBuilder builder() {
    return new PQRSBuilder();
  }

  public PQRSBuilder idUsuario(Integer idUsuario) {
    this.pqrs.setIdUsuario(idUsuario);
    return this;
  }

  public PQRSBuilder pNombre(String pNombre) {
    this.pqrs.setpNombre(pNombre);
    return this;
  }

  public PQRSBuilder sNombres(String sNombres) {
    this.pqrs.setsNombres(sNombres);
    return this;
  }

  public PQRSBuilder pApellido(String pApellido) {
    this.pqrs.setpApellido(pApellido);
    return this;
  }

  public PQRSBuilder sApellido(String sApellido) {
    this.pqrs.setsApellido(sApellido);
    return this;
  }

  public PQRSBuilder tipoDoc(TipoDoc tipoDoc) {
    this.pqrs.setTipoDoc(tipoDoc);
    return this;
  }

  public PQRSBuilder numeroDoc(String numeroDoc) {
    this.pqrs.setNumeroDoc(numeroDoc);
    return this;
  }

  public PQRSBuilder contrasena(String contrasena) {
    this.pqrs.setContrasena(contrasena);
    return this;
  }

  public PQRSBuilder rol(Roles rol) {
    this.pqrs.setRol(rol);
    return this;
  }

  public PQRSBuilder timestamps(Timestamps timestamps) {
    this.pqrs.setTimestamps(timestamps);
    return this;
  }

  public PQRS build() {
    return this.pqrs;
  }
}
