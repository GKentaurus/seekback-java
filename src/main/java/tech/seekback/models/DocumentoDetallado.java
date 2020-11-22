/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "documento_detallado")
public class DocumentoDetallado implements Serializable {

  @Id
  @Column(name = "idDetalle")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idDetalle;

  @Column(name = "prefijoDocumento", nullable = false, length = 10)
  private String prefijoDocumento;

  @Column(name = "consecutivo", nullable = false, length = 11)
  private Integer consecutivo;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
  private Producto idProducto;

  @Column(name = "cantidad", nullable = false, length = 11)
  private Integer cantidad;

  @Column(name = "valorUnitario", nullable = false)
  private Double valorUnitario;

  @Embedded
  private Timestamps timestamps;

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

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "DocumentoDetallado("
            + "id = " + idDetalle + ", "
            + "prefijoDocumento = " + prefijoDocumento + ", "
            + "consecutivo = " + consecutivo + ", "
            + "idProducto = " + idProducto + ", "
            + "cantidad = " + cantidad + ", "
            + "valorUnitario = " + valorUnitario + ", "
            + timestamps.toString()
            + ")";
  }

}
