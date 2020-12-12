package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "orden_compra")
@NamedQueries(value = {
  @NamedQuery(name = "OrdenCompra.getAll", query = "SELECT obj FROM OrdenCompra obj WHERE obj.timestamps.deleted_at IS NULL")
})
public class OrdenCompra implements Serializable {

  @Id
  @Column(name = "idOrdenCompra")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor", nullable = false)
  private Proveedor proveedor;

  @Column(name = "fecha", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha;

  @Column(name = "docAsociado", nullable = false, length = 255)
  private String docAsociado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idTRM", nullable = false)
  private TRM trm;

  @Column(name = "factorImport", nullable = false, length = 11)
  private Double factorImport;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idEmpleado", nullable = false)
  private Empleado empleado;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getidOrdenCompra() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Proveedor getProveedor() {
    return proveedor;
  }

  public void setProveedor(Proveedor proveedor) {
    this.proveedor = proveedor;
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

  public TRM getTrm() {
    return trm;
  }

  public void setTrm(TRM trm) {
    this.trm = trm;
  }

  public Double getFactorImport() {
    return factorImport;
  }

  public void setFactorImport(Double factorImport) {
    this.factorImport = factorImport;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + Objects.hashCode(this.id);
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
    final OrdenCompra other = (OrdenCompra) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "OrdenCompra("
            + "id = " + id + ", "
            + "proveedor = " + proveedor + ", "
            + "docAsociado = " + docAsociado + ", "
            + "trm = " + trm + ", "
            + "factorImport = " + factorImport + ", "
            + "empleado = " + empleado + ", "
            + timestamps.toString()
            + ")";
  }

}
