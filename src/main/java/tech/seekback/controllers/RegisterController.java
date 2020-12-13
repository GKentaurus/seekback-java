/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cliente;
import tech.seekback.models.Correo;
import tech.seekback.models.Direccion;
import tech.seekback.models.Telefono;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.CiudadService;
import tech.seekback.services.ClienteService;
import tech.seekback.services.CorreoService;
import tech.seekback.services.DireccionService;
import tech.seekback.services.RolService;
import tech.seekback.services.TelefonoService;
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

  @EJB
  private CiudadService ciudadService;

  @EJB
  private DireccionService direccionService;

  @EJB
  private TelefonoService telefonoService;

  @EJB
  private CorreoService correoService;

  @EJB
  private ClienteService clienteService;

  private Usuario usuario;
  private Direccion direccion;
  private Correo correo;
  private Telefono telefono;
  private Cliente cliente;

  private Integer idTipoDoc;
  private Integer idCiudad;
  private String email;
  private String phoneNumber;
  private String address;
  private String password;
  private String passwordConfirm;

  public RegisterController() {
    usuario = new Usuario();
    direccion = new Direccion();
    correo = new Correo();
    telefono = new Telefono();
    cliente = new Cliente();
  }

//<editor-fold defaultstate="collapsed" desc="Getters && Setters">
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
  //</editor-fold>

  /**
   * Obtiene toda la información suministrada por el usuario al momento de diligenciar el formulario de registro, y
   * asigna la información por defecto a los objetos correspondientes.
   *
   * @throws ConnectionExcep
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeySpecException
   */
  public void register() throws ConnectionExcep, NoSuchAlgorithmException, InvalidKeySpecException, IOException {
    if (this.password.equals(this.passwordConfirm)) {
      // Creación de Timestamp para todos los procesos
      Timestamps timestamps = new Timestamps();
      Date momentum = new Date();
      timestamps.setCreated_at(momentum);
      timestamps.setUpdated_at(momentum);

      // Creación del objeto Usuario
      this.usuario.setTipoDoc(tipoDocService.getOne(this.idTipoDoc));
      this.usuario.setContrasena(password);
      this.usuario.setRol(rolService.getOne(3));
      this.usuario.setTimestamps(timestamps);

      this.usuario = usuarioService.create(usuario);

      // Creación del objeto Direccion
      this.direccion.setUsuario(usuario);
      this.direccion.setPseudonimo("Principal");
      this.direccion.setDireccion(address);
      this.direccion.setTelefono(phoneNumber);
      this.direccion.setCiudad(ciudadService.getOne(idCiudad));
      this.direccion.setEsPrincipal(true);
      this.direccion.setTimestamps(timestamps);

      this.direccion = direccionService.create(direccion);

      // Creación del objeto Telefono
      this.telefono.setUsuario(usuario);
      this.telefono.setNumeroTelefono(phoneNumber);
      this.telefono.setEsPrincipal(true);
      this.telefono.setTimestamps(timestamps);

      this.telefono = telefonoService.create(telefono);

      // Creación del objeto Correo
      this.correo.setUsuario(usuario);
      this.correo.setCorreoElectronico(email);
      this.correo.setEsPrincipal(true);
      this.correo.setTimestamps(timestamps);

      this.correo = correoService.create(correo);

      // Creación del objeto Cliente
      this.cliente.setUsuario(usuario);
      this.cliente.setTimestamps(timestamps);

      this.cliente = clienteService.create(cliente);

      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
    }
  }
}
