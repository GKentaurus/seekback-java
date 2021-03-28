package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.util.Objects;

/**
 * Definición del modelo "Producto"
 *
 * @author veron
 */
@Entity
@Table(name = "producto")
@NamedQueries(value = {
  @NamedQuery(name = "Producto.getAll", query = "SELECT obj FROM Producto obj WHERE obj.timestamps.deleted = false")
})
public class Producto implements EntityTimestamp {

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

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
   * @return <code>categoria</code> del producto.
   * @see CategoriasProducto
   */
  public CategoriasProducto getCategoria() {
    return categoria;
  }

  /**
   * Asigna el valor del atributo <code>categoria</code> del objeto.
   *
   * @param categoria del producto.
   * @see CategoriasProducto
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
   * @return <code>timestamps</code> del producto.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del producto.
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
    return Objects.equals(this.id, other.id);
  }
//</editor-fold>

  @Override
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
