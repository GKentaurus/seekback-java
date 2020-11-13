package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

  @Id
  @Column(name = "idProducto")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idProducto;

  @Column(name = "modeloProducto", nullable = false, length = 100)
  private String modeloProducto;

  @Column(name = "descripcion", nullable = false, length = 255)
  private String descripcion;

  @Column(name = "precioVenta", nullable = false, length = 11)
  private Double precioVenta;

  @Column(name = "idCategoria", nullable = false)
  @ManyToOne
  private CategoriasProducto idCategoria;

  @Column(name = "estado", nullable = false)
  private Boolean estado;

  @Embedded
  private Timestamps timestamps;

//<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Integer idProducto) {
    this.idProducto = idProducto;
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

  public Double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(Double precioVenta) {
    this.precioVenta = precioVenta;
  }

  public CategoriasProducto getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(CategoriasProducto idCategoria) {
    this.idCategoria = idCategoria;
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

  @Override
  public String toString() {
    return "Producto("
            + "id = " + idProducto + ", "
            + "modeloProducto = " + modeloProducto + ", "
            + "descripcion = " + descripcion + ", "
            + "precioVenta = " + precioVenta + ", "
            + "idCategoria = " + idCategoria + ", "
            + "estado = " + estado + ", "
            + timestamps.toString()
            + ")";
  }
}
