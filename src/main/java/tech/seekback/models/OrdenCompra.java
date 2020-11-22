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
@Table(name = "orden_compra")
public class OrdenCompra implements Serializable {

  @Id
  @Column(name = "idOrdenCompra")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idOrdenCompra;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor", nullable = false)
  private Proveedor idProveedor;

  @Column(name = "fecha", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fecha;

  @Column(name = "docAsociado", nullable = false, length = 255)
  private String docAsociado;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idTRM", referencedColumnName = "idTRM", nullable = false)
  private TRM idTrm;

  @Column(name = "factorImport", nullable = false, length = 11)
  private Double factorImport;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado", nullable = false)
  private Empleado idEmpleado;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getidOrdenCompra() {
    return idOrdenCompra;
  }

  public void setIdOrdenCompra(Integer idordenCompra) {
    this.idOrdenCompra = idOrdenCompra;
  }

  public Proveedor getIdproveedor() {
    return idProveedor;
  }

  public void setIdproveedor(Proveedor idProveedor) {
    this.idProveedor = idProveedor;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public String getDocAsociado() {
    return docAsociado;
  }

  public void setDocAsociado(String docAsociado) {
    this.docAsociado = docAsociado;
  }

  public TRM getIdTrm() {
    return idTrm;
  }

  public void setIdTrm(TRM idTrm) {
    this.idTrm = idTrm;
  }

  public Double getFactorImport() {
    return factorImport;
  }

  public void setFactorImport(Double factorImport) {
    this.factorImport = factorImport;
  }

  public Empleado getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Empleado idEmpleado) {
    this.idEmpleado = idEmpleado;
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
    return "OrdenCompra("
            + "id = " + idOrdenCompra + ", "
            + "idProveedor = " + idProveedor + ", "
            + "docAsociado = " + docAsociado + ", "
            + "idTrm = " + idTrm + ", "
            + "factorImport = " + factorImport + ", "
            + "idEmpleado = " + idEmpleado + ", "
            + timestamps.toString()
            + ")";
  }

}
