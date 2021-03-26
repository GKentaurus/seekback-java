
package tech.seekback.builders;

import tech.seekback.models.Cotizacion;
import tech.seekback.models.ProformaVenta;
import tech.seekback.models.templates.Timestamps;

import java.util.Date;

/**
 * @author gkentaurus
 */
public class ProformaVentaBuilder {

  private final ProformaVenta proformaVenta;

  private ProformaVentaBuilder() {
    proformaVenta = new ProformaVenta();
  }

  public static ProformaVentaBuilder builder() {
    return new ProformaVentaBuilder();
  }

  public ProformaVentaBuilder id(Integer id) {
    this.proformaVenta.setId(id);
    return this;
  }

  public ProformaVentaBuilder cotizacion(Cotizacion cotizacion) {
    this.proformaVenta.setCotizacion(cotizacion);
    return this;
  }

  public ProformaVentaBuilder fecha(Date fecha) {
    this.proformaVenta.setFecha(fecha);
    return this;
  }

  public ProformaVentaBuilder vencimiento(Date vencimiento) {
    this.proformaVenta.setVencimiento(vencimiento);
    return this;
  }

  public ProformaVentaBuilder timestamps(Timestamps timestamps) {
    this.proformaVenta.setTimestamps(timestamps);
    return this;
  }

  public ProformaVenta build() {
    return this.proformaVenta;
  }
}
