/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;
/**
 *
 * @author danny
 */
@Entity
@Table(name = "documento_detallado")
public class DocumentoDetallado extends Timestamps {

  @Id
  @Column(name = "idDetalle")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idDetalle;
  
  @Column(name = "prefijoDocumento", nullable = false)
  private String prefijoDocumento;
  
  @Column(name = "consecutivo", nullable = false)
  private Integer consecutivo;
  
  // TODO: Revisar relación con la tabla "Producto"
  @Column(name = "idProducto", nullable = false)
  @ManyToOne
  // FIXME: a espera de creaciond de clase Producto
  private Producto idProducto;
  
  @Column(name = "cantidad", nullable = false)
  private Integer cantidad;
  
  @Column(name = "valorUnitario", nullable = false)
  private Double valorUnitario;
  
 //TODO:  se debe revisar al crear las clases pendientes
  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">  

  public Integer getIdDetalle() {
    return idDetalle;
  }

  public void setIdDetalle(Integer idDetalle) {
    this.idDetalle = idDetalle;
  }

  public String getPrefijoDocumento() {
    return prefijoDocumento;
  }

  public void setPrefijoDocumento(String prefijoDocumento) {
    this.prefijoDocumento = prefijoDocumento;
  }

  public Integer getConsecutivo() {
    return consecutivo;
  }

  public void setConsecutivo(Integer consecutivo) {
    this.consecutivo = consecutivo;
  }

  public Producto getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Producto idProducto) {
    this.idProducto = idProducto;
  }

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  public Double getValorUnitario() {
    return valorUnitario;
  }

  public void setValorUnitario(Double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }
  //</editor-fold>
  
  
  @Override
  public String toString(){
    return "DocumentoDetallado("
            + "id = " + idDetalle + ", "
            + "prefijoDocumento = " + prefijoDocumento + ", "
            + "consecutivo = " + consecutivo + ", "
            + "idProducto = " + idProducto + ", "
            + "cantidad = " + cantidad + ", "
            + "valorUnitario = " + valorUnitario + ", "
            + super.toString() 
            + ")";
  }    
  
}
