package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Definición del modelo "Telefono"
 *
 * @author veron
 */
@Entity
@Table(name = "telefonos")
@NamedQueries(value = {
  @NamedQuery(name = "Telefono.getAll", query = "SELECT obj FROM Telefono obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "Telefono.getByIdUsuario", query = "SELECT obj FROM Telefono obj WHERE obj.usuario.id = :idUsuario AND obj.timestamps.deleted = false"),
  @NamedQuery(name = "Telefono.getByIdPrincipal", query = "SELECT obj FROM Telefono obj WHERE obj.usuario.id = :idUsuario AND obj.esPrincipal = 1 AND obj.timestamps.deleted = false")
})
public class Telefono implements Serializable {

  @Id
  @Column(name = "idTelefono")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
   * @return <code>usuario</code> relacionado con el telefono.
   * @see Usuario
   */
  public Usuario getUsuario() {
    return usuario;
  }

  /**
   * Asigna el valor del atributo <code>usuario</code> del objeto.
   *
   * @param usuario del telefono.
   * @see Usuario
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
   * Retorna el valor del atributo <code>esPrincipal</code> del objeto.
   *
   * @return <code>esPrincipal</code> del telefono.
   */
  public Boolean getEsPrincipal() {
    return esPrincipal;
  }

  /**
   * Asigna el valor del atributo <code>esPrincipal</code> del objeto.
   *
   * @param esPrincipal del telefono.
   */
  public void setEsPrincipal(Boolean esPrincipal) {
    this.esPrincipal = esPrincipal;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> del telefono.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del telefono.
   * @see Timestamps
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
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
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
