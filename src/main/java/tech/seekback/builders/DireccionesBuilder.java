/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Ciudad;
import tech.seekback.models.Direcciones;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class DireccionesBuilder {

  private Direcciones direcciones;

  private DireccionesBuilder() {
    this.direcciones = new Direcciones();
  }

  public static DireccionesBuilder builder() {
    return new DireccionesBuilder();
  }

  public DireccionesBuilder id(Integer id) {
    this.direcciones.setId(id);
    return this;
  }

  public DireccionesBuilder usuario(Usuario usuario) {
    this.direcciones.setUsuario(usuario);
    return this;
  }

  public DireccionesBuilder pseudonimo(String pseudonimo) {
    this.direcciones.setPseudonimo(pseudonimo);
    return this;
  }

  public DireccionesBuilder direccion(String direccion) {
    this.direcciones.setDireccion(direccion);
    return this;
  }

  public DireccionesBuilder telefono(String telefono) {
    this.direcciones.setTelefono(telefono);
    return this;
  }

  public DireccionesBuilder ciudad(Ciudad ciudad) {
    this.direcciones.setCiudad(ciudad);
    return this;
  }

  public DireccionesBuilder timestamps(Timestamps timestamps) {
    this.direcciones.setTimestamps(timestamps);
    return this;
  }

  public Direcciones build() {
    return this.direcciones;
  }
}
