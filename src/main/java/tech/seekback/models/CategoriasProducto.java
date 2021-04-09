
package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.util.Objects;

/**
 * Definición del modelo "CategoriasProducto"
 *
 * @author danny
 */
@Entity
@Table(name = "categorias_producto")
@NamedQueries(value = {
  @NamedQuery(name = "CategoriasProducto.getAll", query = "SELECT obj FROM CategoriasProducto obj WHERE obj.timestamps.deleted = false")
})
public class CategoriasProducto implements EntityTimestamp {

  @Id
  @Column(name = "idCategoria")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombreCategoria", nullable = false, length = 50)
  private String nombreCategoria;

  @Column(name = "faIcon", length = 50)
  private String faIcon;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de las categorías de productos.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de las categorías de productos.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>nombreCategoria</code> del objeto.
   *
   * @return <code>nombreCategoria</code> de las categorías de productos.
   */
  public String getNombreCategoria() {
    return nombreCategoria;
  }

  /**
   * Asigna el valor del atributo <code>nombreCategoria</code> del objeto.
   *
   * @param nombreCategoria de las categorías de productos.
   */
  public void setNombreCategoria(String nombreCategoria) {
    this.nombreCategoria = nombreCategoria;
  }

  /**
   * Retorna el valor del atributo <code>nombreCategoria</code> del objeto.
   *
   * @return <code>nombreCategoria</code> de las categorías de productos.
   */
  public String getFaIcon() {
    return faIcon;
  }

  /**
   * Asigna el valor del atributo <code>nombreCategoria</code> del objeto.
   *
   * @param faIcon de las categorías de productos.
   */
  public void setFaIcon(String faIcon) {
    this.faIcon = faIcon;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> de las categorías de productos.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de las categorías de productos.
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
    final CategoriasProducto other = (CategoriasProducto) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "CategoriasProducto("
      + "id = " + id + ", "
      + "producto = " + nombreCategoria + ", "
      + timestamps.toString()
      + ")";
  }

}
