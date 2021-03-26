
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Definición del modelo "Empleado"
 *
 * @author danny
 */
@Entity
@Table(name = "empleado")
@NamedQueries(value = {
  @NamedQuery(name = "Empleado.getAll", query = "SELECT obj FROM Empleado obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "Empleado.getByIdUsuario", query = "SELECT obj FROM Empleado obj WHERE obj.usuario.id = :idUsuario AND obj.timestamps.deleted = false")
})
public class Empleado implements Serializable {

  @Id
  @Column(name = "idEmpleado")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(name = "idUsuario", nullable = false)
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Usuario usuario;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del empleado.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del empleado.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>usuario</code> del objeto.
   *
   * @return <code>usuario</code> del empleado.
   * @see Usuario
   */
  public Usuario getUsuario() {
    return usuario;
  }

  /**
   * Asigna el valor del atributo <code>usuario</code> del objeto.
   *
   * @param usuario del empleado.
   * @see Usuario
   */
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> del empleado.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del empleado.
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
    hash = 23 * hash + Objects.hashCode(this.id);
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
    final Empleado other = (Empleado) obj;
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
    return "DocumentoDetallado("
      + "id = " + id + ", "
      + "usuario = " + usuario + ", "
      + timestamps.toString()
      + ")";
  }

}
