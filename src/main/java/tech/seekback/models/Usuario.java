package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.tools.Encrypter;

/**
 *
 * @author camorenoc
 */
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries(value = {
  @NamedQuery(name = "Usuario.getAll", query = "SELECT obj FROM Usuario obj")
})
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

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "tipoDoc", referencedColumnName = "idTipoDoc", nullable = false)
  private TipoDoc tipoDoc;

  @Column(name = "numeroDoc", nullable = false, length = 50)
  private String numeroDoc;

  @Column(name = "contrasena", nullable = false, length = 255)
  private String contrasena;

  @Column(name = "salt", nullable = false, length = 255)
  private String salt;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "rol", referencedColumnName = "idRol", nullable = false)
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

  // TODO: Probar método de encriptación
  public void setContrasena(String contrasena) {
    this.salt = Encrypter.getSalt(100);
    this.contrasena = Encrypter.generateSecurePassword(contrasena, this.salt);
  }

  public String getContrasena() {
    return contrasena;
  }

  public String getSalt() {
    return salt;
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
  //</editor-fold>

  public boolean verifyPassword(String contrasena) {
    return Encrypter.verifyUserPassword(contrasena, this.contrasena, this.salt);
  }

  @Override
  public String toString() {
    return "Usuario{"
            + "idUsuario = " + idUsuario + ", "
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
