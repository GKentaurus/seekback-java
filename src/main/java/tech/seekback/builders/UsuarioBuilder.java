
package tech.seekback.builders;

import tech.seekback.models.Rol;
import tech.seekback.models.TipoDoc;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author gkentaurus
 */
public class UsuarioBuilder {

  private final Usuario usuario;

  private UsuarioBuilder() {
    this.usuario = new Usuario();
  }

  public static UsuarioBuilder builder() {
    return new UsuarioBuilder();
  }

  public UsuarioBuilder idUsuario(Integer idUsuario) {
    this.usuario.setId(idUsuario);
    return this;
  }

  public UsuarioBuilder primerNombre(String primerNombre) {
    this.usuario.setPrimerNombre(primerNombre);
    return this;
  }

  public UsuarioBuilder otrosNombres(String otrosNombres) {
    this.usuario.setOtrosNombres(otrosNombres);
    return this;
  }

  public UsuarioBuilder primerApellido(String primerApellido) {
    this.usuario.setPrimerApellido(primerApellido);
    return this;
  }

  public UsuarioBuilder otrosApellidos(String otrosApellidos) {
    this.usuario.setOtrosApellidos(otrosApellidos);
    return this;
  }

  public UsuarioBuilder tipoDoc(TipoDoc tipoDoc) {
    this.usuario.setTipoDoc(tipoDoc);
    return this;
  }

  public UsuarioBuilder numeroDoc(String numeroDoc) {
    this.usuario.setNumeroDoc(numeroDoc);
    return this;
  }

  public UsuarioBuilder contrasena(String contrasena) throws NoSuchAlgorithmException, InvalidKeySpecException {
    this.usuario.setContrasena(contrasena);
    return this;
  }

  public UsuarioBuilder rol(Rol rol) {
    this.usuario.setRol(rol);
    return this;
  }

  public UsuarioBuilder timestamps(Timestamps timestamps) {
    this.usuario.setTimestamps(timestamps);
    return this;
  }

  public Usuario build() {
    return this.usuario;
  }
}
