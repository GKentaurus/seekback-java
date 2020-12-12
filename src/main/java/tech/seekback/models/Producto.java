package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "producto")
@NamedQueries(value = {
  @NamedQuery(name = "Producto.getAll", query = "SELECT obj FROM Producto obj WHERE obj.timestamps.deleted_at IS NULL")
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

  @Column(name = "serial", nullable = false, length = 255)
  private String serial;

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
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getModeloProducto() {
    return modeloProducto;
  }

  public void setModeloProducto(String modeloProducto) {
    this.modeloProducto = modeloProducto;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  public Double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(Double precioVenta) {
    this.precioVenta = precioVenta;
  }

  public CategoriasProducto getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriasProducto categoria) {
    this.categoria = categoria;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

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
  public String toString() {
    return "Producto("
            + "id = " + id + ", "
            + "modeloProducto = " + modeloProducto + ", "
            + "descripcion = " + descripcion + ", "
            + "serial = " + serial + ", "
            + "precioVenta = " + precioVenta + ", "
            + "categoria = " + categoria + ", "
            + "estado = " + estado + ", "
            + timestamps.toString()
            + ")";
  }
}
