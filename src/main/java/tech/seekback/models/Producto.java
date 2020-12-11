package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "Producto"
 *
 * @author veron
 */
@Entity
@Table(name = "producto")
@NamedQueries(value = {
  @NamedQuery(name = "Producto.getAll", query = "SELECT obj FROM Producto obj")
})
public class Producto implements Serializable {

  @Id
  @Column(name = "idProducto")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "modeloProducto", nullable = false, length = 100)
  private String modeloProducto;

  @Column(name = "descripcion", nullable = false, length = 255)
  private String descripcion;

  @Column(name = "precioVenta", nullable = false, length = 11)
  private Double precioVenta;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idCategoria", nullable = false)
  private CategoriasProducto categoria;

  @Column(name = "estado", nullable = false)
  private Boolean estado;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del producto.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del producto.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>modeloProducto</code> del objeto.
   *
   * @return <code>modeloProducto</code> del producto.
   */
  public String getModeloProducto() {
    return modeloProducto;
  }

  /**
   * Asigna el valor del atributo <code>modeloProducto</code> del objeto.
   *
   * @param modeloProducto del producto.
   */
  public void setModeloProducto(String modeloProducto) {
    this.modeloProducto = modeloProducto;
  }

  /**
   * Retorna el valor del atributo <code>descripcion</code> del objeto.
   *
   * @return <code>descripcion</code> del producto.
   */
  public String getDescripcion() {
    return descripcion;
  }

  /**
   * Asigna el valor del atributo <code>descripcion</code> del objeto.
   *
   * @param descripcion del producto.
   */
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * Retorna el valor del atributo <code>precioVenta</code> del objeto.
   *
   * @return <code>precioVenta</code> del producto.
   */
  public Double getPrecioVenta() {
    return precioVenta;
  }

  /**
   * Asigna el valor del atributo <code>precioVenta</code> del objeto.
   *
   * @param precioVenta del producto.
   */
  public void setPrecioVenta(Double precioVenta) {
    this.precioVenta = precioVenta;
  }

  /**
   * Retorna el valor del atributo <code>categoria</code> del objeto.
   *
   * @see CategoriasProducto
   * @return <code>categoria</code> del producto.
   */
  public CategoriasProducto getCategoria() {
    return categoria;
  }

  /**
   * Asigna el valor del atributo <code>categoria</code> del objeto.
   *
   * @see CategoriasProducto
   * @param categoria del producto.
   */
  public void setCategoria(CategoriasProducto categoria) {
    this.categoria = categoria;
  }

  /**
   * Retorna el valor del atributo <code>estado</code> del objeto.
   *
   * @return <code>estado</code> del producto.
   */
  public Boolean getEstado() {
    return estado;
  }

  /**
   * Asigna el valor del atributo <code>estado</code> del objeto.
   *
   * @param estado del producto.
   */
  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> del producto.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps del producto.
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 73 * hash + Objects.hashCode(this.id);
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
    final Producto other = (Producto) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
//</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información
   * relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
  public String toString() {
    return "Producto("
            + "id = " + id + ", "
            + "modeloProducto = " + modeloProducto + ", "
            + "descripcion = " + descripcion + ", "
            + "precioVenta = " + precioVenta + ", "
            + "categoria = " + categoria + ", "
            + "estado = " + estado + ", "
            + timestamps.toString()
            + ")";
  }
}
