package tech.seekback.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.MessagingException;
import tech.seekback.dao.interfaces.CiudadDAO;
import tech.seekback.dao.interfaces.DepartamentoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.*;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.*;
import tech.seekback.tools.MailService;

/**
 * @author danny
 */
@Named
@SessionScoped
public class LoginController extends CustomController implements Serializable {

  @EJB
  private DepartamentoDAO departamentoDAO;

  @EJB
  private PaisService paisService;

  @EJB
  private CiudadDAO ciudadDAO;

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

  @EJB
  private MailService mailService;

  @EJB
  private CorreoService correosService;

  private Direccion direccion;
  private Telefono telefono;
  private Usuario cliente;

  private Integer idPaisSeleccionado;
  private List<Departamento> departamentoSeleccionado;

  private List<Pais> paises;
  private Integer idDepartamentoSeleccionado;
  private List<Ciudad> ciudadSeleccionada;

  private List<TipoDoc> tipoDocs;

  private Integer idTipoDoc;
  private Integer idCiudad;
  private String phoneNumber;
  private String address;
  private String passwordConfirm;

  // TODO: Usar este boolean en la vista de perfil de usuario, para mostrar un mensaje que diga "Bienvenido de vuelta"
  private boolean cuentaReactivada = false;
  private Usuario usuario;
  private Correo correo;

  private String password;
  private String email;

//  public LoginController() {
//    usuario = new Usuario();
//    direccion = new Direccion();
//    correo = new Correo();
//    telefono = new Telefono();
//    cliente = new Usuario();
//  }
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

  public Correo getCorreo() {
    return correo;
  }

  public void setCorreo(Correo correo) {
    this.correo = correo;
  }

  public boolean getCuentaReactivada() {
    return cuentaReactivada;
  }

  public void setCuentaReactivada(boolean cuentaReactivada) {
    this.cuentaReactivada = cuentaReactivada;
  }
//</editor-fold>

  private boolean validateEmail() throws ConnectionExcep {
    // Validar si el correo existe
    this.correo = new Correo();
    this.correo = correosService.getByCorreo(email);
    return Objects.nonNull(correo);
  }

  private boolean validateUser() throws ConnectionExcep {
    this.usuario = new Usuario();
    this.usuario = usuarioService.getOne(correo.getUsuario().getId());
    return Objects.nonNull(usuario);
  }

  private void reactiveUser() throws ConnectionExcep {
    if (this.usuario.getTimestamps().getDeleted()) {
      System.out.println("Restaurando usuario eliminado");
      this.usuario.getTimestamps().setDeleted(false);
      this.usuario.getTimestamps().resetDeleted_at();
      this.usuarioService.update(this.usuario);
      this.cuentaReactivada = true;
    }
  }

  public void register() throws ConnectionExcep, NoSuchAlgorithmException, InvalidKeySpecException, IOException, MessagingException {
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

      this.mailService.sendEmail(
              correo.getCorreoElectronico(),
              "Bienvenido a Seekback",
              "Su registro ha sido completado satisfactoriamente."
      );

      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
    }
  }

  public void login() throws ConnectionExcep, IOException {
    FacesContext fc = FacesContext.getCurrentInstance();
    // TODO: Enviar los mensajes de error o confirmación a través de addMessage()

    if (validateEmail()) {
      if (validateUser()) {
        if (usuario.verificarContrasena(password)) {
          reactiveUser();
          redirectTo(usuario.getRol().getId());
        } else {
          this.usuario = null;
          FacesMessage message = new FacesMessage("Contraseña invalida");
          fc.addMessage("messs:mesag", message);
        }
      } else {
        FacesMessage message = new FacesMessage("El usuario no esta registrado");
        fc.addMessage("messs:mesag", message);
        this.usuario = null;
      }
    } else {
      this.correo = null;
      FacesMessage message = new FacesMessage("El correo no esta registrado");
      fc.addMessage("messs:mesag", message);
    }
  }

  public void restorePassword() throws ConnectionExcep, MessagingException, IOException {
    System.out.println("Recuperando contraseña...");
    FacesContext fc = FacesContext.getCurrentInstance();
    if (validateEmail()) {
      if (validateUser()) {
        String alphabet = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
        String temporalPassword = "";
        Random rrn = new Random();
        for (int i = 0; i < 10; i++) {
          int randomIndex = rrn.nextInt(alphabet.length() - 1);
          temporalPassword = temporalPassword.concat(alphabet.substring(randomIndex, randomIndex + 1));
        }
        usuario.setContrasena(temporalPassword);
        usuarioService.update(usuario);
        this.mailService.sendEmail(
                this.correo.getCorreoElectronico(),
                "¿Olvidaste tu contraseña en Seekback?",
                "Hola" + this.usuario.getPrimerNombre() + " " + this.usuario.getOtrosNombres() + ":\n\n"
                + "Su nueva contraseña es " + temporalPassword + "\n\n"
                + "Usala para iniciar sesión la próxima vez. Le recomendamos la cambie tan pronto sea posible.\n\n"
                + "Cordialmente,\n\n"
                + "El equipo de desarrollo de Seekback");
      } else {
        FacesMessage message = new FacesMessage("El usuario no esta registrado");
        fc.addMessage("messs:mesag", message);
        this.usuario = null;
      }
    } else {
      this.correo = null;
      FacesMessage message = new FacesMessage("El correo no esta registrado");
      fc.addMessage("messs:mesag", message);
    }
    redirectTo("/login.xhtml");
  }

  public void logout() throws IOException {
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();
    ec.invalidateSession();
    ec.redirect(ec.getRequestContextPath() + "/login.xhtml");

  }

  public boolean isLogged() throws IOException {
    return usuario != null;
  }

  public void validate() throws IOException {
    if (isLogged()) {
      redirectTo(usuario.getRol().getId());
    }
  }

  public void validate(Integer rol) throws IOException {
    if (isLogged()) {
      if (!Objects.equals(rol, usuario.getRol().getId())) {
        redirectTo("/index.xhtml");
      }
    } else {
      redirectTo("/errorPages/403.xhtml");
    }
  }

  public void redirectTo(String ruta) throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + ruta);
  }

  public void redirectTo(Integer rol) throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    String ruta;
    if (rol == null) {
      ruta = "/index.xhtml";
    } else {
      ruta = "/frames/cuenta.xhtml";
    }
    ec.redirect(ec.getRequestContextPath() + ruta);
  }

  public Integer getIdPaisSeleccionado() {
    return idPaisSeleccionado;
  }

  public void setIdPaisSeleccionado(Integer idPaisSeleccionado) {
    try {
      if (Objects.nonNull(idPaisSeleccionado)) {
        departamentoSeleccionado = departamentoDAO
                .getByIdPais(idPaisSeleccionado);
      } else {
        departamentoSeleccionado = null;
      }
    } catch (ConnectionExcep ex) {
      ex.printStackTrace();
    }
    this.idPaisSeleccionado = idPaisSeleccionado;
  }

  public List<Departamento> getDepartamentoSeleccionado() {
    return departamentoSeleccionado;
  }

  public List<Pais> getPaises() {
    try {
      if (Objects.isNull(paises)) {
        paises = paisService.getAll();
      }
    } catch (ConnectionExcep ex) {
      System.out.println("Error de la consulta 'paises'.");
      ex.printStackTrace();
    }
    return paises;

  }

  public Integer getIdDepartamentoSeleccionado() {
    return idDepartamentoSeleccionado;
  }

  public void setIdDepartamentoSeleccionado(Integer idDepartamentoSeleccionado) {
    try {
      if (Objects.nonNull(idDepartamentoSeleccionado)) {
        ciudadSeleccionada = ciudadDAO
                .getByIdDepartamento(idDepartamentoSeleccionado);
      } else {
        ciudadSeleccionada = null;
      }
    } catch (ConnectionExcep ex) {
      ex.printStackTrace();
    }
    this.idDepartamentoSeleccionado = idDepartamentoSeleccionado;
  }

  public List<Ciudad> getCiudadSeleccionada() {
    return ciudadSeleccionada;
  }

  @PostConstruct
  public void init() {
    try {
      tipoDocs = tipoDocService.getAll();
    } catch (ConnectionExcep ex) {
      System.out.println("Error de la consulta 'TIPO DOC'.");
      ex.printStackTrace();
    }
  }

  public List<TipoDoc> getTipoDocs() {
    return tipoDocs;
  }
}
