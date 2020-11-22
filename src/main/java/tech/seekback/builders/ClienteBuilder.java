/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Cliente;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class ClienteBuilder {

  private Cliente cliente;

  private ClienteBuilder() {
    this.cliente = new Cliente();
  }

  public static ClienteBuilder builder() {
    return new ClienteBuilder();
  }

  public ClienteBuilder id(Integer id) {
    this.cliente.setId(id);
    return this;
  }

  public ClienteBuilder usuario(Usuario usuario) {
    this.cliente.setUsuario(usuario);
    return this;
  }

  public ClienteBuilder timestamps(Timestamps timestamps) {
    this.cliente.setTimestamps(timestamps);
    return this;
  }

  public Cliente build() {
    return this.cliente;
  }
}
