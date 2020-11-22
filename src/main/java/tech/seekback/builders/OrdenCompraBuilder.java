/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import java.util.Date;
import tech.seekback.models.Empleado;
import tech.seekback.models.OrdenCompra;
import tech.seekback.models.Proveedor;
import tech.seekback.models.TRM;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class OrdenCompraBuilder {

  private final OrdenCompra ordenCompra;

  private OrdenCompraBuilder() {
    this.ordenCompra = new OrdenCompra();
  }

  public static OrdenCompraBuilder builder() {
    return new OrdenCompraBuilder();
  }

  public OrdenCompraBuilder id(Integer id) {
    this.ordenCompra.setId(id);
    return this;
  }

  public OrdenCompraBuilder proveedor(Proveedor proveedor) {
    this.ordenCompra.setProveedor(proveedor);
    return this;
  }

  public OrdenCompraBuilder fecha(Date fecha) {
    this.ordenCompra.setFecha(fecha);
    return this;
  }

  public OrdenCompraBuilder docAsociado(String docAsociado) {
    this.ordenCompra.setDocAsociado(docAsociado);
    return this;
  }

  public OrdenCompraBuilder trm(TRM trm) {
    this.ordenCompra.setTrm(trm);
    return this;
  }

  public OrdenCompraBuilder factorImport(Double factorImport) {
    this.ordenCompra.setFactorImport(factorImport);
    return this;
  }

  public OrdenCompraBuilder empleado(Empleado empleado) {
    this.ordenCompra.setEmpleado(empleado);
    return this;
  }

  public OrdenCompraBuilder timestamps(Timestamps timestamps) {
    this.ordenCompra.setTimestamps(timestamps);
    return this;
  }

  public OrdenCompra build() {
    return this.ordenCompra;
  }
}
