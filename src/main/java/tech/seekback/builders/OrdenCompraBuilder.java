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

  public OrdenCompraBuilder idOrdenCompra(Integer id) {
    this.ordenCompra.setIdOrdenCompra(id);
    System.out.println("\n sdasd");
    return this;
  }

  public OrdenCompraBuilder idProveedor(Proveedor idproveedor) {
    this.ordenCompra.setIdproveedor(idproveedor);
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

  public OrdenCompraBuilder idTrm(TRM idTrm) {
    this.ordenCompra.setIdTrm(idTrm);
    return this;
  }

  public OrdenCompraBuilder factorImport(Double factorImport) {
    this.ordenCompra.setFactorImport(factorImport);
    return this;
  }

  public OrdenCompraBuilder idEmpleado(Empleado idEmpleado) {
    this.ordenCompra.setIdEmpleado(idEmpleado);
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
