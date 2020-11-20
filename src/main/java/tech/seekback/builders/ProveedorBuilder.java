/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Cliente;
import tech.seekback.models.Proveedor;
import tech.seekback.models.TipoDoc;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class ProveedorBuilder {

  private Proveedor proveedor;

  private ProveedorBuilder() {
    this.proveedor = new Proveedor();
  }

  public static ProveedorBuilder builder() {
    return new ProveedorBuilder();
  }

  public ProveedorBuilder idProveedor(Integer idProveedor) {
    this.proveedor.setIdProveedor(idProveedor);
    return this;
  }

  public ProveedorBuilder tipoDoc(TipoDoc tipoDoc) {
    this.proveedor.setTipoDoc(tipoDoc);
    return this;
  }

  public ProveedorBuilder numeroRoc(String numeroDoc) {
    this.proveedor.setNumeroDoc(numeroDoc);
    return this;
  }

  public ProveedorBuilder digitoVerif(String digitoVerif) {
    this.proveedor.setDigitoVerif(digitoVerif);
    return this;
  }

  public ProveedorBuilder razonSocial(String razonSocial) {
    this.proveedor.setRazonSocial(razonSocial);
    return this;
  }

  public ProveedorBuilder telefono(String telefono) {
    this.proveedor.setTelefono(telefono);
    return this;
  }

  public ProveedorBuilder email(String email) {
    this.proveedor.setEmail(email);
    return this;
  }

  public ProveedorBuilder idcliente(Cliente idCliente) {
    this.proveedor.setIdCliente(idCliente);
    return this;
  }

  public ProveedorBuilder timestamps(Timestamps timestamps) {
    this.proveedor.setTimestamps(timestamps);
    return this;
  }

  public Proveedor build() {
    return this.proveedor;
  }
}
