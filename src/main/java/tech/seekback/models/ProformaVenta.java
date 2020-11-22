package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "proforma_venta")
@NamedQueries(value = {
  @NamedQuery(name = "ProformaVenta.getAll", query = "SELECT obj FROM ProformaVenta obj")
})
public class ProformaVenta implements Serializable {

  @Id
  @Column(name = "idProforma")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idCotizacion", nullable = false)
  private Cotizacion cotizacion;

  @Column(name = "fecha", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha;

  @Column(name = "vencimiento", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date vencimiento;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Cotizacion getCotizacion() {
    return cotizacion;
  }

  public void setCotizacion(Cotizacion cotizacion) {
    this.cotizacion = cotizacion;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Date getVencimiento() {
    return vencimiento;
  }

  public void setVencimiento(Date vencimiento) {
    this.vencimiento = vencimiento;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
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
