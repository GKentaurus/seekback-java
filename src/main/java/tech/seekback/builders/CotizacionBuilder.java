
package tech.seekback.builders;

import tech.seekback.models.*;
import tech.seekback.models.templates.Timestamps;

import java.util.Date;

/**
 * @author gkentaurus
 */
public class CotizacionBuilder {

  private final Cotizacion cotizacion;

  private CotizacionBuilder() {
    this.cotizacion = new Cotizacion();
  }

  public static CotizacionBuilder builder() {
    return new CotizacionBuilder();
  }

  public CotizacionBuilder id(Integer id) {
    this.cotizacion.setId(id);
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

  public CotizacionBuilder trm(TRM idTRM) {
    this.cotizacion.setTrm(idTRM);
    return this;
  }

  public CotizacionBuilder estado(EstadosCotizacion estado) {
    this.cotizacion.setEstado(estado);
    return this;
  }

  public CotizacionBuilder empleado(Empleado empleado) {
    this.cotizacion.setEmpleado(empleado);
    return this;
  }

  public CotizacionBuilder cliente(Cliente cliente) {
    this.cotizacion.setCliente(cliente);
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
