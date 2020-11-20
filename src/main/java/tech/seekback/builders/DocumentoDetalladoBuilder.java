/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.DocumentoDetallado;
import tech.seekback.models.Producto;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class DocumentoDetalladoBuilder {

  private DocumentoDetallado documentoDetallado;

  private DocumentoDetalladoBuilder() {
    this.documentoDetallado = new DocumentoDetallado();
  }

  public static DocumentoDetalladoBuilder builder() {
    return new DocumentoDetalladoBuilder();
  }

  public DocumentoDetalladoBuilder idDetalle(Integer idDetalle) {
    this.documentoDetallado.setIdDetalle(idDetalle);
    return this;
  }

  public DocumentoDetalladoBuilder prefijoDocumento(String prefijoDocumento) {
    this.documentoDetallado.setPrefijoDocumento(prefijoDocumento);
    return this;
  }

  public DocumentoDetalladoBuilder consecutivo(Integer consecutivo) {
    this.documentoDetallado.setConsecutivo(consecutivo);
    return this;
  }

  public DocumentoDetalladoBuilder idProducto(Producto idProducto) {
    this.documentoDetallado.setIdProducto(idProducto);
    return this;
  }

  public DocumentoDetalladoBuilder cantidad(Integer cantidad) {
    this.documentoDetallado.setCantidad(cantidad);
    return this;
  }

  public DocumentoDetalladoBuilder valorUnitario(Double valorUnitario) {
    this.documentoDetallado.setValorUnitario(valorUnitario);
    return this;
  }

  public DocumentoDetalladoBuilder timestamps(Timestamps timestamps) {
    this.documentoDetallado.setTimestamps(timestamps);
    return this;
  }

  public DocumentoDetallado build() {
    return this.documentoDetallado;
  }
}
