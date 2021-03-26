
package tech.seekback.builders;

import tech.seekback.models.DocumentoDetallado;
import tech.seekback.models.Producto;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class DocumentoDetalladoBuilder {

  private final DocumentoDetallado documentoDetallado;

  private DocumentoDetalladoBuilder() {
    this.documentoDetallado = new DocumentoDetallado();
  }

  public static DocumentoDetalladoBuilder builder() {
    return new DocumentoDetalladoBuilder();
  }

  public DocumentoDetalladoBuilder id(Integer id) {
    this.documentoDetallado.setId(id);
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

  public DocumentoDetalladoBuilder producto(Producto producto) {
    this.documentoDetallado.setProducto(producto);
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
