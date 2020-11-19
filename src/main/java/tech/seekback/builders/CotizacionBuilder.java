/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import java.util.Date;
import tech.seekback.models.Cliente;
import tech.seekback.models.Cotizacion;
import tech.seekback.models.Empleado;
import tech.seekback.models.EstadosCotizacion;
import tech.seekback.models.TRM;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class CotizacionBuilder {

  private Cotizacion cotizacion;

  private CotizacionBuilder() {
    this.cotizacion = new Cotizacion();
  }

  public static CotizacionBuilder builder() {
    return new CotizacionBuilder();
  }

  public CotizacionBuilder idCotizacion(String requerimiento) {
    this.cotizacion.setIdCotizacion(Integer.SIZE);
    return this;
  }

  public CotizacionBuilder fecha(Date fecha) {
    this.cotizacion.setFecha(fecha);
    return this;
  }

  public CotizacionBuilder vencimiento(Date vencimiento) {
    this.cotizacion.setVencimiento(vencimiento);
    return this;
  }

  public CotizacionBuilder idTRM(TRM idTRM) {
    this.cotizacion.setIdTRM(idTRM);
    return this;
  }

  public CotizacionBuilder idEstado(EstadosCotizacion idEstado) {
    this.cotizacion.setIdEstado(idEstado);
    return this;
  }

  public CotizacionBuilder idEmpleado(Empleado idEmpleado) {
    this.cotizacion.setIdEmpleado(idEmpleado);
    return this;
  }

  public CotizacionBuilder idCliente(Cliente idCliente) {
    this.cotizacion.setIdCliente(idCliente);
    return this;
  }

  public CotizacionBuilder timestamps(Timestamps timestamps) {
    this.cotizacion.setTimestamps(timestamps);
    return this;
  }

  public Cotizacion build() {
    return this.cotizacion;
  }
}
