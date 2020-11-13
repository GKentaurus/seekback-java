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
public class ProformaVenta implements Serializable {

  @Id
  @Column(name = "idProforma")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idProforma;

  @Column(name = "cotizacionAsociada", nullable = false)
  @ManyToOne
  private Cotizacion cotizacionAsociada;

  @Column(name = "fecha", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fecha;

  @Column(name = "vencimiento", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date vencimiento;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdProforma() {
    return idProforma;
  }

  public void setIdProforma(Integer idProforma) {
    this.idProforma = idProforma;
  }

  public Cotizacion getCotizacionAsociada() {
    return cotizacionAsociada;
  }

  public void setCotizacionAsociada(Cotizacion cotizacionAsociada) {
    this.cotizacionAsociada = cotizacionAsociada;
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
    return "ProformaVenta{" + "idProforma=" + idProforma
            + ", cotizacionAsociada=" + cotizacionAsociada
            + ", fecha=" + fecha
            + ", vencimiento=" + vencimiento
            + timestamps.toString()
            + '}';
  }
}
