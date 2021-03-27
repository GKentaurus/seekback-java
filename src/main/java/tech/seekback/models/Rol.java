
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Definición del modelo "Rol"
 *
 * @author gkentaurus
 */
@Entity
@Table(name = "roles")
@NamedQueries(value = {
  @NamedQuery(name = "Rol.getAll", query = "SELECT obj FROM Rol obj WHERE obj.timestamps.deleted = false")
})
public class Rol implements Serializable {

  @Id
  @Column(name = "idRol")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombreRol", nullable = false, length = 50)
  private String nombreRol;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del rol.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del rol.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>nombreRol</code> del objeto.
   *
   * @return <code>nombreRol</code> del rol.
   */
  public String getNombreRol() {
    return nombreRol;
  }

  /**
   * Asigna el valor del atributo <code>nombreRol</code> del objeto.
   *
   * @param nombreRol del rol.
   */
  public void setNombreRol(String nombreRol) {
    this.nombreRol = nombreRol;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> del rol.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del rol.
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
    hash = 11 * hash + Objects.hashCode(this.id);
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
    final Rol other = (Rol) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Roles("
      + "id = " + id + ", "
      + "nombreRol = " + nombreRol + ", "
      + timestamps.toString()
      + ")";
  }
}
