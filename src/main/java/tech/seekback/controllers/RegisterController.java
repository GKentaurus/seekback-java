/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.RolService;
import tech.seekback.services.TipoDocService;
import tech.seekback.services.UsuarioService;

/**
 *
 * @author danny
 */
@ViewScoped
@Named
public class RegisterController implements Serializable {

  @EJB
  private UsuarioService usuarioService;

  @EJB
  private TipoDocService tipoDocService;

  @EJB
  private RolService rolService;

  private Usuario usuario;
  private Integer idTipoDoc;
  private Integer idCiudad;
  private String email;
  private String phoneNumber;
  private String address;
  private String password;
  private String passwordConfirm;

  public RegisterController() {
    usuario = new Usuario();
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Integer getIdTipoDoc() {
    return idTipoDoc;
  }

  public void setIdTipoDoc(Integer id) {
    this.idTipoDoc = id;
  }

  public Integer getIdCiudad() {
    return idCiudad;
  }

  public void setIdCiudad(Integer id) {
    this.idCiudad = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }

  public void register() throws ConnectionExcep {
    if (this.password.equals(this.passwordConfirm)) {
      this.usuario.setTipoDoc(tipoDocService.getOne(this.idTipoDoc));
      this.usuario.setContrasena(this.password);
      this.usuario.setRol(rolService.getOne(3));
      Timestamps timestamps = new Timestamps();
      Date momentum = new Date();
      timestamps.setCreated_at(momentum);
      timestamps.setUpdated_at(momentum);
      this.usuario.setTimestamps(timestamps);

      this.usuario = usuarioService.create(usuario);

      System.out.print("El último ID es: ");
      System.out.println(this.usuario.toString());
    }
  }
}
