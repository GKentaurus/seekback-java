package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "Telefono"
 *
 * @author veron
 */
@Entity
@Table(name = "telefonos")
@NamedQueries(value = {
  @NamedQuery(name = "Telefono.getAll", query = "SELECT obj FROM Telefono obj WHERE obj.timestamps.deleted_at IS NULL"),
  @NamedQuery(name = "Telefono.getByIdUsuario", query = "SELECT obj FROM Telefono obj WHERE obj.usuario.id = :idUsuario"),
  @NamedQuery(name = "Telefono.getByIdPrincipal", query = "SELECT obj FROM Telefono obj WHERE obj.usuario.id = :idUsuario AND obj.esPrincipal = 1")
})
public class Telefono implements Serializable {

  @Id
  @Column(name = "idTelefono")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idUsuario", nullable = false)
  private Usuario usuario;

  @Column(name = "numeroTelefono", nullable = false, length = 20)
  private String numeroTelefono;

  @Column(name = "esPrincipal", nullable = false)
  private Boolean esPrincipal;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del telefono.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del telefono.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>usuario</code> del objeto.
   *
   * @see Usuario
   * @return <code>usuario</code> relacionado con el telefono.
   */
  public Usuario getUsuario() {
    return usuario;
  }

  /**
   * Asigna el valor del atributo <code>usuario</code> del objeto.
   *
   * @see Usuario
   * @param usuario del telefono.
   */
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  /**
   * Retorna el valor del atributo <code>numeroTelefono</code> del objeto.
   *
   * @return <code>numeroTelefono</code> del telefono.
   */
  public String getNumeroTelefono() {
    return numeroTelefono;
  }

  /**
   * Asigna el valor del atributo <code>numeroTelefono</code> del objeto.
   *
   * @param numeroTelefono del telefono.
   */
  public void setNumeroTelefono(String numeroTelefono) {
    this.numeroTelefono = numeroTelefono;
  }

  /**
   * Retorna el valor del atributo <code>numeroTelefono</code> del objeto.
   *
   * @return <code>numeroTelefono</code> del telefono.
   */
  public Boolean getEsPrincipal() {
    return esPrincipal;
  }

  /**
   * Asigna el valor del atributo <code>numeroTelefono</code> del objeto.
   *
   * @param numeroTelefono del telefono.
   */
  public void setEsPrincipal(Boolean esPrincipal) {
    this.esPrincipal = esPrincipal;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> del telefono.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps del telefono.
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 97 * hash + Objects.hashCode(this.id);
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
    final Telefono other = (Telefono) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres que resume toda la información relevante
   * del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
  public String toString() {
    return "Telefono{"
            + "idTelefono=" + id + ", "
            + "idUsuario=" + usuario + ", "
            + "numeroTelefono=" + numeroTelefono + ", "
            + "esPrincipal=" + esPrincipal + ", "
            + timestamps.toString()
            + '}';
  }

}
