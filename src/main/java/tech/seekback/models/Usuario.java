package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.tools.Encrypter;

/**
 * Definición del modelo "Usuario"
 *
 * @author gkentaurus
 */
@Entity
@Table(name = "usuario")
@NamedQueries(value = {
  @NamedQuery(name = "Usuario.getAll", query = "SELECT obj FROM Usuario obj WHERE obj.timestamps.deleted_at IS NULL")
})
public class Usuario implements Serializable {

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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tipoDoc", nullable = false)
  private TipoDoc tipoDoc;

  @Column(name = "numeroDoc", nullable = false, length = 50)
  private String numeroDoc;

  @Column(name = "contrasena", nullable = false, length = 255)
  private String contrasena;

  @Column(name = "salt", nullable = false, length = 255)
  private String salt;

  @ManyToOne(fetch = FetchType.LAZY)
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
   * @see TipoDoc
   * @return <code>tipoDoc</code> del usuario
   */
  public TipoDoc getTipoDoc() {
    return tipoDoc;
  }

  /**
   * Asigna el valor del atributo <code>tipoDoc</code> del objeto.
   *
   * @see TipoDoc
   * @param tipoDoc del usuario
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
   * @see Rol
   * @return <code>rol</code> del usuario
   */
  public Rol getRol() {
    return rol;
  }

  /**
   * Asigna el valor del atributo <code>rol</code> del objeto.
   *
   * @see Rol
   * @param rol del usuario
   */
  public void setRol(Rol rol) {
    this.rol = rol;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> del usuario
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps del usuario
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
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información
   * relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
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
