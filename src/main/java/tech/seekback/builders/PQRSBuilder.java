
package tech.seekback.builders;

import tech.seekback.models.*;
import tech.seekback.models.templates.Timestamps;

import java.util.Date;

/**
 * @author gkentaurus
 */
public class PQRSBuilder {

  private final PQRS pqrs;

  private PQRSBuilder() {
    this.pqrs = new PQRS();
  }

  public static PQRSBuilder builder() {
    return new PQRSBuilder();
  }

  public PQRSBuilder id(Integer id) {
    this.pqrs.setId(id);
    return this;
  }

  public PQRSBuilder tipoSolicitud(TipoSolicitud tipoSolicitud) {
    this.pqrs.setTipoSolicitud(tipoSolicitud);
    return this;
  }

  public PQRSBuilder cliente(Cliente cliente) {
    this.pqrs.setCliente(cliente);
    return this;
  }

  public PQRSBuilder administrador(Administrador administrador) {
    this.pqrs.setAdministrador(administrador);
    return this;
  }

  public PQRSBuilder area(String area) {
    this.pqrs.setArea(area);
    return this;
  }

  public PQRSBuilder comentario(String comentario) {
    this.pqrs.setComentario(comentario);
    return this;
  }

  public PQRSBuilder estado(EstadosFidelizacion estado) {
    this.pqrs.setEstado(estado);
    return this;
  }

  public PQRSBuilder fechaRespuesta(Date fechaRespuesta) {
    this.pqrs.setFechaRespuesta(fechaRespuesta);
    return this;
  }

  public PQRSBuilder timestamps(Timestamps timestamps) {
    this.pqrs.setTimestamps(timestamps);
    return this;
  }

  public PQRS build() {
    return this.pqrs;
  }
}
