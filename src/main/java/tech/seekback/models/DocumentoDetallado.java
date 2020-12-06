/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "documento_detallado")
@NamedQueries(value = {
  @NamedQuery(name = "DocumentoDetallado.getAll", query = "SELECT obj FROM DocumentoDetallado obj")
})
public class DocumentoDetallado implements Serializable {

  @Id
  @Column(name = "idDetalle")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "prefijoDocumento", nullable = false, length = 10)
  private String prefijoDocumento;

  @Column(name = "consecutivo", nullable = false, length = 11)
  private Integer consecutivo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idProducto", nullable = false)
  private Producto producto;

  @Column(name = "cantidad", nullable = false, length = 11)
  private Integer cantidad;

  @Column(name = "valorUnitario", nullable = false)
  private Double valorUnitario;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
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

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
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
    final DocumentoDetallado other = (DocumentoDetallado) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "DocumentoDetallado("
            + "id = " + id + ", "
            + "prefijoDocumento = " + prefijoDocumento + ", "
            + "consecutivo = " + consecutivo + ", "
            + "producto = " + producto + ", "
            + "cantidad = " + cantidad + ", "
            + "valorUnitario = " + valorUnitario + ", "
            + timestamps.toString()
            + ")";
  }

}
