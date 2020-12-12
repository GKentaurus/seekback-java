/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "Cotizacion"
 *
 * @author danny
 */
@Entity
@Table(name = "cotizacion")
@NamedQueries(value = {
  @NamedQuery(name = "Cotizacion.getAll", query = "SELECT obj FROM Cotizacion obj WHERE obj.timestamps.deleted_at IS NULL")
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idTRM", nullable = false)
  private TRM trm;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idEstado", nullable = false)
  private EstadosCotizacion estado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idEmpleado", nullable = false)
  private Empleado empleado;

  @ManyToOne(fetch = FetchType.LAZY)
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
   * @see TRM
   * @return <code>trm</code> de la cotización.
   */
  public TRM getTrm() {
    return trm;
  }

  /**
   * Asigna el valor del atributo <code>trm</code> del objeto.
   *
   * @see TRM
   * @param trm de la cotización.
   */
  public void setTrm(TRM trm) {
    this.trm = trm;
  }

  /**
   * Retorna el valor del atributo <code>estado</code> del objeto.
   *
   * @see EstadosCotizacion
   * @return <code>estado</code> de la cotización.
   */
  public EstadosCotizacion getEstado() {
    return estado;
  }

  /**
   * Asigna el valor del atributo <code>estado</code> del objeto.
   *
   * @see EstadosCotizacion
   * @param estado de la cotización.
   */
  public void setEstado(EstadosCotizacion estado) {
    this.estado = estado;
  }

  /**
   * Retorna el valor del atributo <code>empleado</code> del objeto.
   *
   * @see Empleado
   * @return <code>empleado</code> de la cotización.
   */
  public Empleado getEmpleado() {
    return empleado;
  }

  /**
   * Asigna el valor del atributo <code>empleado</code> del objeto.
   *
   * @see Empleado
   * @param empleado de la cotización.
   */
  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  /**
   * Retorna el valor del atributo <code>cliente</code> del objeto.
   *
   * @see Cliente
   * @return <code>cliente</code> de la cotización.
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo <code>cliente</code> del objeto.
   *
   * @see Cliente
   * @param cliente de la cotización.
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> de la cotización.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps de la cotización.
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
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información relevante del objeto.
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
