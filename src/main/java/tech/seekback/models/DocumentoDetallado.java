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
 * Definición del modelo "DocumentoDetallado"
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
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del documento detallado.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del documento detallado.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>prefijoDocumento</code> del objeto.
   *
   * @return <code>prefijoDocumento</code> del documento detallado.
   */
  public String getPrefijoDocumento() {
    return prefijoDocumento;
  }

  /**
   * Asigna el valor del atributo <code>prefijoDocumento</code> del objeto.
   *
   * @param prefijoDocumento del documento detallado.
   */
  public void setPrefijoDocumento(String prefijoDocumento) {
    this.prefijoDocumento = prefijoDocumento;
  }

  /**
   * Retorna el valor del atributo <code>consecutivo</code> del objeto.
   *
   * @return <code>consecutivo</code> del documento detallado.
   */
  public Integer getConsecutivo() {
    return consecutivo;
  }

  /**
   * Asigna el valor del atributo <code>consecutivo</code> del objeto.
   *
   * @param consecutivo del documento detallado.
   */
  public void setConsecutivo(Integer consecutivo) {
    this.consecutivo = consecutivo;
  }

  /**
   * Retorna el valor del atributo <code>producto</code> del objeto.
   *
   * @see Producto
   * @return <code>producto</code> del documento detallado.
   */
  public Producto getProducto() {
    return producto;
  }

  /**
   * Asigna el valor del atributo <code>producto</code> del objeto.
   *
   * @see Producto
   * @param producto del documento detallado.
   */
  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  /**
   * Retorna el valor del atributo <code>cantidad</code> del objeto.
   *
   * @return <code>cantidad</code> del documento detallado.
   */
  public Integer getCantidad() {
    return cantidad;
  }

  /**
   * Asigna el valor del atributo <code>cantidad</code> del objeto.
   *
   * @param cantidad del documento detallado.
   */
  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  /**
   * Retorna el valor del atributo <code>valorUnitario</code> del objeto.
   *
   * @return <code>valorUnitario</code> del documento detallado.
   */
  public Double getValorUnitario() {
    return valorUnitario;
  }

  /**
   * Asigna el valor del atributo <code>valorUnitario</code> del objeto.
   *
   * @param valorUnitario del documento detallado.
   */
  public void setValorUnitario(Double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> del documento detallado.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps del documento detallado.
   */
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
  /**
   * Retorna una cadena de caracteres de que resume toda la información
   * relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
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
