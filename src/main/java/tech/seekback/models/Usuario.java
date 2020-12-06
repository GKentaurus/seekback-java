package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.tools.Encrypter;

/**
 *
 * @author camorenoc
 */
@Entity
@Table(name = "usuario")
@NamedQueries(value = {
  @NamedQuery(name = "Usuario.getAll", query = "SELECT obj FROM Usuario obj"),
  @NamedQuery(name = "Usuario.getByEmail", query = "SELECT obj.contrasena, co.correoElectronico FROM Usuario obj INNER JOIN Correos co ON obj.id = co.usuario WHERE co.esPrincipal = 1")
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
  private Roles rol;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public void setContrasena(String contrasena) {
    this.salt = Encrypter.getSalt(100);
    this.contrasena = Encrypter.generateSecurePassword(contrasena, this.salt);
  }

  public String getContrasena() {
    return contrasena;
  }

  public boolean verificarContrasena(String contrasena) {
    return Encrypter.verifyUserPassword(contrasena, this.contrasena, this.salt);
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
