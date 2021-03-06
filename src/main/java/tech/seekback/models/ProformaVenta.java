package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Definición del modelo "ProformaVenta"
 *
 * @author veron
 */
@Entity
@Table(name = "proforma_venta")
@NamedQueries(value = {
  @NamedQuery(name = "ProformaVenta.getAll", query = "SELECT obj FROM ProformaVenta obj WHERE obj.timestamps.deleted = false")
})
public class ProformaVenta implements EntityTimestamp {

  @Id
  @Column(name = "idProforma")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idCotizacion", nullable = false)
  private Cotizacion cotizacion;

  @Column(name = "fecha", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @Column(name = "vencimiento", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date vencimiento;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la proforma de venta.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la proforma de venta.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>cotizacion</code> del objeto.
   *
   * @return <code>cotizacion</code> de la proforma de venta.
   * @see Cotizacion
   */
  public Cotizacion getCotizacion() {
    return cotizacion;
  }

  /**
   * Asigna el valor del atributo <code>cotizacion</code> del objeto.
   *
   * @param cotizacion de la proforma de venta.
   * @see Cotizacion
   */
  public void setCotizacion(Cotizacion cotizacion) {
    this.cotizacion = cotizacion;
  }

  /**
   * Retorna el valor del atributo <code>fecha</code> del objeto.
   *
   * @return <code>fecha</code> de la proforma de venta.
   */
  public Date getFecha() {
    return fecha;
  }

  /**
   * Asigna el valor del atributo <code>fecha</code> del objeto.
   *
   * @param fecha de la proforma de venta.
   */
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  /**
   * Retorna el valor del atributo <code>vencimiento</code> del objeto.
   *
   * @return <code>vencimiento</code> de la proforma de venta.
   */
  public Date getVencimiento() {
    return vencimiento;
  }

  /**
   * Asigna el valor del atributo <code>vencimiento</code> del objeto.
   *
   * @param vencimiento de la proforma de venta.
   */
  public void setVencimiento(Date vencimiento) {
    this.vencimiento = vencimiento;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> de la proforma de venta.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de la proforma de venta.
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 59 * hash + Objects.hashCode(this.id);
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
    final ProformaVenta other = (ProformaVenta) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "ProformaVenta{"
      + "idProforma = " + id + ", "
      + "cotizacion = " + cotizacion + ", "
      + "fecha = " + fecha + ", "
      + "vencimiento = " + vencimiento + ", "
      + timestamps.toString()
      + '}';
  }
}
