/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import java.util.Date;
import tech.seekback.models.Cotizacion;
import tech.seekback.models.ProformaVenta;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class ProformaVentaBuilder {

  private ProformaVenta proformaVenta;

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
