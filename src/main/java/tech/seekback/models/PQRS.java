
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Definición del modelo "PQRS"
 *
 * @author camorenoc
 */
@Entity
@Table(name = "pqrs")
@NamedQueries(value = {
  @NamedQuery(name = "PQRS.getAll", query = "SELECT obj FROM PQRS obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "PQRS.getAllCount", query = "SELECT COUNT(obj) FROM PQRS obj WHERE obj.estado.id <> 3 AND obj.timestamps.deleted = false")
})
public class PQRS implements Serializable {

  @Id
  @Column(name = "idPQRS")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idTipoSolicitud", nullable = false)
  private TipoSolicitud tipoSolicitud;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idCliente", nullable = false)
  private Cliente cliente;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idAdministrador", nullable = false)
  private Administrador administrador;

  @Column(name = "area", nullable = false, length = 100)
  private String area;

  @Column(name = "comentario", nullable = false, length = 255)
  private String comentario;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idEstado", nullable = false)
  private EstadosFidelizacion estado;

  @Column(name = "fechaRespuesta", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaRespuesta;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del PQRS.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del PQRS.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>tipoSolicitud</code> del objeto.
   *
   * @return <code>tipoSolicitud</code> del PQRS.
   * @see TipoSolicitud
   */
  public TipoSolicitud getTipoSolicitud() {
    return tipoSolicitud;
  }

  /**
   * Asigna el valor del atributo <code>tipoSolicitud</code> del objeto.
   *
   * @param tipoSolicitud del PQRS.
   * @see TipoSolicitud
   */
  public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
    this.tipoSolicitud = tipoSolicitud;
  }

  /**
   * Retorna el valor del atributo <code>area</code> del objeto.
   *
   * @return <code>area</code> del PQRS.
   */
  public String getArea() {
    return area;
  }

  /**
   * Asigna el valor del atributo <code>area</code> del objeto.
   *
   * @param area del PQRS.
   */
  public void setArea(String area) {
    this.area = area;
  }

  /**
   * Retorna el valor del atributo <code>estado</code> del objeto.
   *
   * @return <code>estado</code> del PQRS.
   * @see EstadosFidelizacion
   */
  public EstadosFidelizacion getEstado() {
    return estado;
  }

  /**
   * Asigna el valor del atributo <code>estado</code> del objeto.
   *
   * @param estado del PQRS.
   * @see EstadosFidelizacion
   */
  public void setEstado(EstadosFidelizacion estado) {
    this.estado = estado;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> del PQRS.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del PQRS.
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  /**
   * Retorna el valor del atributo <code>cliente</code> del objeto.
   *
   * @return <code>cliente</code> del PQRS.
   * @see Cliente
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo <code>cliente</code> del objeto.
   *
   * @param cliente del PQRS.
   * @see Cliente
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * Retorna el valor del atributo <code>administrador</code> del objeto.
   *
   * @return <code>administrador</code> del PQRS.
   * @see Administrador
   */
  public Administrador getAdministrador() {
    return administrador;
  }

  /**
   * Asigna el valor del atributo <code>administrador</code> del objeto.
   *
   * @param administrador del PQRS.
   * @see Administrador
   */
  public void setAdministrador(Administrador administrador) {
    this.administrador = administrador;
  }

  /**
   * Retorna el valor del atributo <code>comentario</code> del objeto.
   *
   * @return <code>comentario</code> del PQRS.
   */
  public String getComentario() {
    return comentario;
  }

  /**
   * Asigna el valor del atributo <code>comentario</code> del objeto.
   *
   * @param comentario del PQRS.
   */
  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  /**
   * Retorna el valor del atributo <code>fechaRespuesta</code> del objeto.
   *
   * @return <code>fechaRespuesta</code> del PQRS.
   */
  public Date getFechaRespuesta() {
    return fechaRespuesta;
  }

  /**
   * Asigna el valor del atributo <code>fechaRespuesta</code> del objeto.
   *
   * @param fechaRespuesta del PQRS.
   */
  public void setFechaRespuesta(Date fechaRespuesta) {
    this.fechaRespuesta = fechaRespuesta;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 37 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final PQRS other = (PQRS) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
  public String toString() {
    return "PQRS{"
      + "id = " + id + ", "
      + "tipoSolicitud = " + tipoSolicitud + ", "
      + "cliente = " + cliente + ", "
      + "administrador = " + administrador + ", "
      + "area = " + area + ", "
      + "comentario = " + comentario + ", "
      + "estado = " + estado
      + "fechaRespuesta = " + fechaRespuesta
      + timestamps.toString()
      + '}';
  }
}
