package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.tools.Encrypter;

import javax.persistence.*;
import java.util.Objects;

/**
 * Definición del modelo "Usuario"
 *
 * @author gkentaurus
 */
@Entity
@Table(name = "usuario")
@NamedQueries(value = {
  // <editor-fold desc="Queries para Administradores" defaultstate="collapsed">
  @NamedQuery(
    name = "Administrador.getAll",
    query = "SELECT obj " +
      "FROM Usuario obj " +
      "WHERE obj.timestamps.deleted = false " +
      "AND obj.rol.nombreRol = 'Administrador'"
  ),
  @NamedQuery(
    name = "Administrador.getOne",
    query = "SELECT obj " +
      "FROM Usuario obj " +
      "WHERE obj.id = :idAdministrador " +
      "AND obj.timestamps.deleted = false " +
      "AND obj.rol.nombreRol = 'Administrador'"
  ),
  // </editor-fold>

  // <editor-fold desc="Queries para Clientes" defaultstate="collapsed">
  @NamedQuery(
    name = "Cliente.getAll",
    query = "SELECT obj " +
      "FROM Usuario obj " +
      "WHERE obj.timestamps.deleted = false " +
      "AND obj.rol.nombreRol = 'Cliente'"
  ),
  @NamedQuery(
    name = "Cliente.getOne",
    query = "SELECT obj " +
      "FROM Usuario obj " +
      "WHERE obj.id = :idCliente " +
      "AND obj.timestamps.deleted = false " +
      "AND obj.rol.nombreRol = 'Cliente'"
  ),
  // </editor-fold>

  // <editor-fold desc="Queries para Empleados" defaultstate="collapsed">
  @NamedQuery(
    name = "Empleado.getAll",
    query = "SELECT obj " +
      "FROM Usuario obj " +
      "WHERE obj.timestamps.deleted = false " +
      "AND obj.rol.nombreRol = 'Empleado'"
  ),
  @NamedQuery(
    name = "Empleado.getOne",
    query = "SELECT obj " +
      "FROM Usuario obj " +
      "WHERE obj.id = :idEmpleado " +
      "AND obj.timestamps.deleted = false " +
      "AND obj.rol.nombreRol = 'Empleado'"
  ),
  // </editor-fold>

  // <editor-fold desc="Queries para Usuarios en general" defaultstate="collapsed">
  @NamedQuery(
    name = "Usuario.getAll",
    query = "SELECT obj " +
      "FROM Usuario obj " +
      "WHERE obj.timestamps.deleted = false"
  ),
  // </editor-fold>
})
public class Usuario implements EntityTimestamp {

  @Id
  @Column(name = "idUsuario")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "primerNombre", nullable = false, length = 50)
  private String primerNombre;

  @Column(name = "otrosNombres", nullable = true, length = 50)
  private String otrosNombres;

  @Column(name = "primerApellido", nullable = false, length = 50)
  private String primerApellido;

  @Column(name = "otrosApellidos", nullable = true, length = 50)
  private String otrosApellidos;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "tipoDoc", nullable = false)
  private TipoDoc tipoDoc;

  @Column(name = "numeroDoc", nullable = false, length = 50)
  private String numeroDoc;

  @Column(name = "contrasena", nullable = false, length = 255)
  private String contrasena;

  @Column(name = "salt", nullable = false, length = 255)
  private String salt;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "rol", nullable = false)
  private Rol rol;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del usuario.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del usuario.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>primerNombre</code> del objeto.
   *
   * @return <code>primerNombre</code> del usuario
   */
  public String getPrimerNombre() {
    return primerNombre;
  }

  /**
   * Asigna el valor del atributo <code>primerNombre</code> del objeto.
   *
   * @param primerNombre del usuario
   */
  public void setPrimerNombre(String primerNombre) {
    this.primerNombre = primerNombre;
  }

  /**
   * Retorna el valor del atributo <code>oitrosNombres</code> del objeto.
   *
   * @return <code>oitrosNombres</code> del usuario
   */
  public String getOtrosNombres() {
    return otrosNombres;
  }

  /**
   * Asigna el valor del atributo <code>otrosNombres</code> del objeto.
   *
   * @param otrosNombres del usuario
   */
  public void setOtrosNombres(String otrosNombres) {
    this.otrosNombres = otrosNombres;
  }

  /**
   * Retorna el valor del atributo <code>primerApellido</code> del objeto.
   *
   * @return <code>primerApellido</code> del usuario
   */
  public String getPrimerApellido() {
    return primerApellido;
  }

  /**
   * Asigna el valor del atributo <code>primerApellido</code> del objeto.
   *
   * @param primerApellido del usuario
   */
  public void setPrimerApellido(String primerApellido) {
    this.primerApellido = primerApellido;
  }

  /**
   * Retorna el valor del atributo <code>otrosApellidos</code> del objeto.
   *
   * @return <code>otrosApellidos</code> del usuario
   */
  public String getOtrosApellidos() {
    return otrosApellidos;
  }

  /**
   * Asigna el valor del atributo <code>otrosApellidos</code> del objeto.
   *
   * @param otrosApellidos del usuario
   */
  public void setOtrosApellidos(String otrosApellidos) {
    this.otrosApellidos = otrosApellidos;
  }

  /**
   * Retorna el valor del atributo <code>tipoDoc</code> del objeto.
   *
   * @return <code>tipoDoc</code> del usuario
   * @see TipoDoc
   */
  public TipoDoc getTipoDoc() {
    return tipoDoc;
  }

  /**
   * Asigna el valor del atributo <code>tipoDoc</code> del objeto.
   *
   * @param tipoDoc del usuario
   * @see TipoDoc
   */
  public void setTipoDoc(TipoDoc tipoDoc) {
    this.tipoDoc = tipoDoc;
  }

  /**
   * Retorna el valor del atributo <code>numeroDoc</code> del objeto.
   *
   * @return <code>numeroDoc</code> del usuario
   */
  public String getNumeroDoc() {
    return numeroDoc;
  }

  /**
   * Asigna el valor del atributo <code>numeroDoc</code> del objeto.
   *
   * @param numeroDoc del usuario
   */
  public void setNumeroDoc(String numeroDoc) {
    this.numeroDoc = numeroDoc;
  }

  /**
   * Retorna el valor del atributo <code>contraseña</code> del objeto.
   *
   * @return <code>contrasena</code> del usuario
   */
  public String getContrasena() {
    return contrasena;
  }

  /**
   * Asigna el valor del atributo <code>contraseña</code> del objeto.
   *
   * @param contrasena del usuario
   */
  public void setContrasena(String contrasena) {
    this.salt = Encrypter.getSalt(100);
    this.contrasena = Encrypter.generateSecurePassword(contrasena, this.salt);
  }

  /**
   * Comprueba si la contraseña almacenada coincide con la proveida.
   *
   * @param contrasena del usuario
   * @return <code>true</code> si las contraseñas coinciden.
   */
  public boolean verificarContrasena(String contrasena) {
    return Encrypter.verifyUserPassword(contrasena, this.contrasena, this.salt);
  }

  /**
   * Retorna el valor del atributo <code>rol</code> del objeto.
   *
   * @return <code>rol</code> del usuario
   * @see Rol
   */
  public Rol getRol() {
    return rol;
  }

  /**
   * Asigna el valor del atributo <code>rol</code> del objeto.
   *
   * @param rol del usuario
   * @see Rol
   */
  public void setRol(Rol rol) {
    this.rol = rol;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> del usuario
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del usuario
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Usuario other = (Usuario) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Usuario{"
      + "idUsuario = " + id + ", "
      + "primerNombre = " + primerNombre + ", "
      + "otrosNombres = " + otrosNombres + ", "
      + "primerApellido = " + primerApellido + ", "
      + "otrosApellidos = " + otrosApellidos + ", "
      + "tipoDoc = " + tipoDoc + ", "
      + "numeroDoc = " + numeroDoc + ", "
      + "rol = " + rol + ", "
      + timestamps.toString()
      + '}';
  }
}
