
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Definición del modelo "Correo"
 *
 * @author danny
 */
@Entity
@Table(name = "correos")
@NamedQueries(value = {
  @NamedQuery(name = "Correo.getAll", query = "SELECT obj FROM Correo obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "Correo.getByCorreo", query = "SELECT obj FROM Correo obj WHERE obj.correoElectronico = :CorreoRec AND obj.timestamps.deleted = false"),
  @NamedQuery(name = "Correo.getByIdPrincipal", query = "SELECT obj FROM Correo obj WHERE obj.usuario.id = :idUsuario AND obj.esPrincipal = TRUE AND obj.timestamps.deleted = false")
})
public class Correo implements Serializable {

  @Id
  @Column(name = "idCorreo")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idUsuario", nullable = false)
  private Usuario usuario;

  @Column(name = "correoElectronico", nullable = false, unique = true, length = 255)
  private String correoElectronico;

  @Column(name = "esPrincipal", nullable = false)
  private boolean esPrincipal;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del correo.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del correo.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>usuario</code> del objeto.
   *
   * @return <code>usuario</code> del correo.
   * @see Usuario
   */
  public Usuario getUsuario() {
    return usuario;
  }

  /**
   * Asigna el valor del atributo <code>usuario</code> del objeto.
   *
   * @param usuario del correo.
   * @see Usuario
   */
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  /**
   * Retorna el valor del atributo <code>correoElectronico</code> del objeto.
   *
   * @return <code>correoElectronico</code> del correo.
   */
  public String getCorreoElectronico() {
    return correoElectronico;
  }

  /**
   * Asigna el valor del atributo <code>correoElectronico</code> del objeto.
   *
   * @param correoElectronico del correo.
   */
  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  /**
   * Retorna el valor del atributo <code>esPrincipal</code> del objeto.
   *
   * @return <code>esPrincipal</code> del correo.
   */
  public boolean getEsPrincipal() {
    return esPrincipal;
  }

  /**
   * Asigna el valor del atributo <code>esPrincipal</code> del objeto.
   *
   * @param esPrincipal del correo.
   */
  public void setEsPrincipal(Boolean esPrincipal) {
    this.esPrincipal = esPrincipal;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> del correo.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del correo.
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
    hash = 47 * hash + Objects.hashCode(this.id);
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
    final Correo other = (Correo) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
  public String toString() {
    return "Correos("
      + "id = " + id + ", "
      + "usuario = " + usuario + ", "
      + "correo = " + correoElectronico + ", "
      + "principal = " + esPrincipal + ", "
      + timestamps.toString()
      + ")";
  }
}
