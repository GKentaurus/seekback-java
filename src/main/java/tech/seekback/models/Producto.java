package tech.seekback.models;

import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "Producto")
public class Producto extends Timestamps {

  @Id
  @Column(name = "idProducto")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idProducto;

  @Column(name = "modeloProducto",length = 255, nullable = false)
  private String modeloProducto;

  @Column(name = "descripcion",length = 255, nullable = false)
  private String descripcion;
  
  @Column(name = "precioVenta",nullable = false)
  private Double precioVenta;
  
  @Column(name = "idCategoria", nullable = false)
  private Integer idCategoria;
  
  @Column(name = "estado",nullable = false)
  private Integer estado;
    
//<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  
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
            + ")";
  }
}
