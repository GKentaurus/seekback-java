
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Definición del modelo "Cotizacion"
 *
 * @author danny
 */
@Entity
@Table(name = "cotizacion")
@NamedQueries(value = {
  @NamedQuery(name = "Cotizacion.getAll", query = "SELECT obj FROM Cotizacion obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "Cotizacion.getByIdEmpleado", query = "SELECT obj FROM Cotizacion obj WHERE obj.empleado.id = :idEmpleado and obj.timestamps.deleted = false")
})
public class Cotizacion implements Serializable {

  @Id
  @Column(name = "idCotizacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "requerimiento", nullable = false, length = 255)
  private String requerimiento;

  @Column(name = "fecha", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @Column(name = "vencimiento", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date vencimiento;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idTRM", nullable = false)
  private TRM trm;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idEstado", nullable = false)
  private EstadosCotizacion estado;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idEmpleado", nullable = false)
  private Empleado empleado;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idCliente", nullable = false)
  private Cliente cliente;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la cotización.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la cotización.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>requerimiento</code> del objeto.
   *
   * @return <code>requerimiento</code> de la cotización.
   */
  public String getRequerimiento() {
    return requerimiento;
  }

  /**
   * Asigna el valor del atributo <code>requerimiento</code> del objeto.
   *
   * @param requerimiento de la cotización.
   */
  public void setRequerimiento(String requerimiento) {
    this.requerimiento = requerimiento;
  }

  /**
   * Retorna el valor del atributo <code>fecha</code> del objeto.
   *
   * @return <code>fecha</code> de la cotización.
   */
  public Date getFecha() {
    return fecha;
  }

  /**
   * Asigna el valor del atributo <code>fecha</code> del objeto.
   *
   * @param fecha de la cotización.
   */
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  /**
   * Retorna el valor del atributo <code>vencimiento</code> del objeto.
   *
   * @return <code>vencimiento</code> de la cotización.
   */
  public Date getVencimiento() {
    return vencimiento;
  }

  /**
   * Asigna el valor del atributo <code>vencimiento</code> del objeto.
   *
   * @param vencimiento de la cotización.
   */
  public void setVencimiento(Date vencimiento) {
    this.vencimiento = vencimiento;
  }

  /**
   * Retorna el valor del atributo <code>trm</code> del objeto.
   *
   * @return <code>trm</code> de la cotización.
   * @see TRM
   */
  public TRM getTrm() {
    return trm;
  }

  /**
   * Asigna el valor del atributo <code>trm</code> del objeto.
   *
   * @param trm de la cotización.
   * @see TRM
   */
  public void setTrm(TRM trm) {
    this.trm = trm;
  }

  /**
   * Retorna el valor del atributo <code>estado</code> del objeto.
   *
   * @return <code>estado</code> de la cotización.
   * @see EstadosCotizacion
   */
  public EstadosCotizacion getEstado() {
    return estado;
  }

  /**
   * Asigna el valor del atributo <code>estado</code> del objeto.
   *
   * @param estado de la cotización.
   * @see EstadosCotizacion
   */
  public void setEstado(EstadosCotizacion estado) {
    this.estado = estado;
  }

  /**
   * Retorna el valor del atributo <code>empleado</code> del objeto.
   *
   * @return <code>empleado</code> de la cotización.
   * @see Empleado
   */
  public Empleado getEmpleado() {
    return empleado;
  }

  /**
   * Asigna el valor del atributo <code>empleado</code> del objeto.
   *
   * @param empleado de la cotización.
   * @see Empleado
   */
  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  /**
   * Retorna el valor del atributo <code>cliente</code> del objeto.
   *
   * @return <code>cliente</code> de la cotización.
   * @see Cliente
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo <code>cliente</code> del objeto.
   *
   * @param cliente de la cotización.
   * @see Cliente
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> de la cotización.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de la cotización.
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.id);
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
    final Cotizacion other = (Cotizacion) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información
   * relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
  public String toString() {
    return "Cotizacion("
      + "id = " + id + ", "
      + "requerimiento = " + requerimiento + ", "
      + "fecha = " + fecha + ", "
      + "fechaVencimiento = " + vencimiento + ", "
      + "trm = " + trm + ", "
      + "estado = " + estado + ", "
      + "empleado = " + empleado + ", "
      + "cliente = " + cliente + ", "
      + timestamps.toString()
      + ")";
  }

}
