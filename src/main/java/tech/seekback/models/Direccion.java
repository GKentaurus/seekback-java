
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Definición del modelo "Direccion"
 *
 * @author camorenoc
 */
@Entity
@Table(name = "direcciones")
@NamedQueries(value = {
  @NamedQuery(name = "Direccion.getAll", query = "SELECT obj FROM Direccion obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "Direccion.getByIdPrincipal", query = "SELECT obj FROM Direccion obj WHERE obj.usuario.id = :idUsuario AND obj.esPrincipal = TRUE AND obj.timestamps.deleted = false")

})
public class Direccion implements Serializable {

  @Id
  @Column(name = "idDirecciones")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idRegistro", nullable = false)
  private Usuario usuario;

  @Column(name = "pseudonimo", nullable = false, length = 30)
  private String pseudonimo;

  @Column(name = "direccion", nullable = false, length = 100)
  private String direccion;

  @Column(name = "telefono", nullable = false, length = 20)
  private String telefono;

  @Column(name = "esPrincipal", nullable = false)
  private boolean esPrincipal;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "localizacion", nullable = false)
  private Ciudad ciudad;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la dirección.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la dirección.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>usuario</code> del objeto.
   *
   * @return <code>usuario</code> de la dirección.
   * @see Usuario
   */
  public Usuario getUsuario() {
    return usuario;
  }

  /**
   * Asigna el valor del atributo <code>usuario</code> del objeto.
   *
   * @param usuario de la dirección.
   * @see Usuario
   */
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  /**
   * Retorna el valor del atributo <code>pseudonimo</code> del objeto.
   *
   * @return <code>pseudonimo</code> de la dirección.
   */
  public String getPseudonimo() {
    return pseudonimo;
  }

  /**
   * Asigna el valor del atributo <code>pseudonimo</code> del objeto.
   *
   * @param pseudonimo de la dirección.
   */
  public void setPseudonimo(String pseudonimo) {
    this.pseudonimo = pseudonimo;
  }

  /**
   * Retorna el valor del atributo <code>direccion</code> del objeto.
   *
   * @return <code>direccion</code> de la dirección.
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * Asigna el valor del atributo <code>direccion</code> del objeto.
   *
   * @param direccion de la dirección.
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * Retorna el valor del atributo <code>telefono</code> del objeto.
   *
   * @return <code>telefono</code> de la dirección.
   */
  public String getTelefono() {
    return telefono;
  }

  /**
   * Asigna el valor del atributo <code>telefono</code> del objeto.
   *
   * @param telefono de la dirección.
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * Retorna si la direccion es principal
   *
   * @return <code>true</code> si esta direccion es principal
   */
  public boolean isEsPrincipal() {
    return esPrincipal;
  }

  /**
   * Asigna a la direccion si es principal
   *
   * @param esPrincipal si esta direccion es principal
   */
  public void setEsPrincipal(boolean esPrincipal) {
    this.esPrincipal = esPrincipal;
  }

  /**
   * Retorna el valor del atributo <code>ciudad</code> del objeto.
   *
   * @return <code>ciudad</code> de la dirección.
   * @see Ciudad
   */
  public Ciudad getCiudad() {
    return ciudad;
  }

  /**
   * Asigna el valor del atributo <code>ciudad</code> del objeto.
   *
   * @param ciudad de la dirección.
   * @see Ciudad
   */
  public void setCiudad(Ciudad ciudad) {
    this.ciudad = ciudad;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> de la dirección.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de la dirección.
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
    final Direccion other = (Direccion) obj;
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
    return "Direcciones{"
      + "id = " + id + ", "
      + "usuario = " + usuario + ", "
      + "pseudonimo = " + pseudonimo + ", "
      + "direccion = " + direccion + ", "
      + "telefono = " + telefono + ", "
      + "ciudad = " + ciudad
      + timestamps.toString()
      + '}';
  }

}
