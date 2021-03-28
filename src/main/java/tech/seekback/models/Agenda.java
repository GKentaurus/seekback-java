
package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Definición del modelo "Agenda"
 *
 * @author danny
 */
@Entity
@Table(name = "agenda")
@NamedQueries(value = {
  @NamedQuery(name = "Agenda.getAll", query = "SELECT obj FROM Agenda obj WHERE obj.timestamps.deleted = false")
})
public class Agenda implements EntityTimestamp {

  @Id
  @Column(name = "idAgenda")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "fecha", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha;

  @Column(name = "observaciones", nullable = false, length = 255)
  private String observaciones;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idEstado", nullable = false)
  private EstadosAgenda estado;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idTipoServicio", nullable = false)
  private TipoServicio tipoServicio;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idCliente", nullable = false)
  private Usuario cliente;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idEmpleado", nullable = true)
  private Usuario empleado;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idAdministrador", nullable = true)
  private Usuario administrador;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la agenda.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la agenda.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>fecha</code> del objeto.
   *
   * @return <code>fecha</code> de la agenda.
   */
  public Date getFecha() {
    return fecha;
  }

  /**
   * Asigna el valor del atributo <code>fecha</code> del objeto.
   *
   * @param fecha de la agenda.
   */
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  /**
   * Retorna el valor del atributo <code>observaciones</code> del objeto.
   *
   * @return <code>observaciones</code> de la agenda.
   */
  public String getObservaciones() {
    return observaciones;
  }

  /**
   * Asigna el valor del atributo <code>observaciones</code> del objeto.
   *
   * @param observaciones de la agenda.
   */
  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  /**
   * Retorna el valor del atributo <code>estado</code> del objeto.
   *
   * @return <code>estado</code> de la agenda.
   * @see EstadosAgenda
   */
  public EstadosAgenda getEstado() {
    return estado;
  }

  /**
   * Asigna el valor del atributo <code>estado</code> del objeto.
   *
   * @param estado de la agenda.
   * @see EstadosAgenda
   */
  public void setEstado(EstadosAgenda estado) {
    this.estado = estado;
  }

  /**
   * Retorna el valor del atributo <code>tipoServicio</code> del objeto.
   *
   * @return <code>tipoServicio</code> de la agenda.
   * @see TipoServicio
   */
  public TipoServicio getTipoServicio() {
    return tipoServicio;
  }

  /**
   * Asigna el valor del atributo <code>tipoServicio</code> del objeto.
   *
   * @param tipoServicio de la agenda.
   * @see TipoServicio
   */
  public void setTipoServicio(TipoServicio tipoServicio) {
    this.tipoServicio = tipoServicio;
  }

  /**
   * Retorna el valor del atributo <code>cliente</code> del objeto.
   *
   * @return <code>cliente</code> de la agenda.
   * @see Usuario
   */
  public Usuario getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo <code>cliente</code> del objeto.
   *
   * @param cliente de la agenda.
   * @see Usuario
   */
  public void setCliente(Usuario cliente) {
    this.cliente = cliente;
  }

  /**
   * Retorna el valor del atributo <code>empleado</code> del objeto.
   *
   * @return <code>empleado</code> de la agenda.
   * @see Usuario
   */
  public Usuario getEmpleado() {
    return empleado;
  }

  /**
   * Asigna el valor del atributo <code>empleado</code> del objeto.
   *
   * @param empleado de la agenda.
   * @see Usuario
   */
  public void setEmpleado(Usuario empleado) {
    this.empleado = empleado;
  }

  /**
   * Retorna el valor del atributo <code>administrador</code> del objeto.
   *
   * @return <code>administrador</code> de la agenda.
   * @see Usuario
   */
  public Usuario getAdministrador() {
    return administrador;
  }

  /**
   * Asigna el valor del atributo <code>administrador</code> del objeto.
   *
   * @param administrador de la agenda.
   * @see Usuario
   */
  public void setAdministrador(Usuario administrador) {
    this.administrador = administrador;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> de la agenda.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de la agenda.
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 3;
    hash = 71 * hash + Objects.hashCode(this.id);
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
    final Agenda other = (Agenda) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Agenda("
      + "id = " + id + ", "
      + "fecha = " + fecha + ", "
      + "observaciones = " + observaciones + ", "
      + "estado = " + estado + ", "
      + "tipoServicio = " + tipoServicio + ", "
      + "cliente = " + cliente + ", "
      + "empleado = " + empleado + ", "
      + "administrador = " + administrador + ", "
      + timestamps.toString()
      + ")";
  }

}
