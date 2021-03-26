
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Definición del modelo "Cliente"
 *
 * @author danny
 */
@Entity
@Table(name = "cliente")
@NamedQueries(value = {
  @NamedQuery(name = "Cliente.getAll", query = "SELECT obj FROM Cliente obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "Cliente.getByIdUsuario", query = "SELECT obj FROM Cliente obj WHERE obj.usuario.id = :idUsuario AND obj.timestamps.deleted = false"),})
public class Cliente implements Serializable {

  @Id
  @Column(name = "idCliente")
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
   * @return <code>id</code> del cliente.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del cliente.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>usuario</code> del objeto.
   *
   * @return <code>usuario</code> del cliente.
   * @see Usuario
   */
  public Usuario getUsuario() {
    return usuario;
  }

  /**
   * Asigna el valor del atributo <code>usuario</code> del objeto.
   *
   * @param usuario del cliente.
   * @see Usuario
   */
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> del cliente.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del cliente.
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
    hash = 59 * hash + Objects.hashCode(this.id);
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
    final Cliente other = (Cliente) obj;
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
    return "CategoriasProducto("
      + "id = " + id + ", "
      + "usuario = " + usuario + ", "
      + timestamps.toString()
      + ")";
  }

}
