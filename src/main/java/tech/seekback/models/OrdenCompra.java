package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Definición del modelo "OrdenCompra"
 *
 * @author veron
 */
@Entity
@Table(name = "orden_compra")
@NamedQueries(value = {
  @NamedQuery(name = "OrdenCompra.getAll", query = "SELECT obj FROM OrdenCompra obj WHERE obj.timestamps.deleted = false")
})
public class OrdenCompra implements Serializable {

  @Id
  @Column(name = "idOrdenCompra")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idProveedor", nullable = false)
  private Proveedor proveedor;

  @Column(name = "fecha", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @Column(name = "docAsociado", nullable = false, length = 50)
  private String docAsociado;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idTRM", nullable = false)
  private TRM trm;

  @Column(name = "factorImport", nullable = false, length = 11)
  private Double factorImport;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idEmpleado", nullable = false)
  private Empleado empleado;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la orden de compra.
   */
  public Integer getidOrdenCompra() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la orden de compra.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>proveedor</code> del objeto.
   *
   * @return <code>proveedor</code> de la orden de compra.
   * @see Proveedor
   */
  public Proveedor getProveedor() {
    return proveedor;
  }

  /**
   * Asigna el valor del atributo <code>proveedor</code> del objeto.
   *
   * @param proveedor de la orden de compra.
   * @see Proveedor
   */
  public void setProveedor(Proveedor proveedor) {
    this.proveedor = proveedor;
  }

  /**
   * Retorna el valor del atributo <code>fecha</code> del objeto.
   *
   * @return <code>fecha</code> de la orden de compra.
   */
  public Date getFecha() {
    return fecha;
  }

  /**
   * Asigna el valor del atributo <code>fecha</code> del objeto.
   *
   * @param fecha de la orden de compra.
   */
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  /**
   * Retorna el valor del atributo <code>docAsociado</code> del objeto.
   *
   * @return <code>docAsociado</code> de la orden de compra.
   */
  public String getDocAsociado() {
    return docAsociado;
  }

  /**
   * Asigna el valor del atributo <code>docAsociado</code> del objeto.
   *
   * @param docAsociado de la orden de compra.
   */
  public void setDocAsociado(String docAsociado) {
    this.docAsociado = docAsociado;
  }

  /**
   * Retorna el valor del atributo <code>trm</code> del objeto.
   *
   * @return <code>trm</code> de la orden de compra.
   * @see TRM
   */
  public TRM getTrm() {
    return trm;
  }

  /**
   * Asigna el valor del atributo <code>trm</code> del objeto.
   *
   * @param trm de la orden de compra.
   * @see TRM
   */
  public void setTrm(TRM trm) {
    this.trm = trm;
  }

  /**
   * Retorna el valor del atributo <code>trm</code> del objeto.
   *
   * @return <code>trm</code> de la orden de compra.
   */
  public Double getFactorImport() {
    return factorImport;
  }

  /**
   * Asigna el valor del atributo <code>factorImport</code> del objeto.
   *
   * @param factorImport de la orden de compra.
   */
  public void setFactorImport(Double factorImport) {
    this.factorImport = factorImport;
  }

  /**
   * Retorna el valor del atributo <code>factorImport</code> del objeto.
   *
   * @return <code>factorImport</code> de la orden de compra.
   * @see Empleado
   */
  public Empleado getEmpleado() {
    return empleado;
  }

  /**
   * Asigna el valor del atributo <code>factorImport</code> del objeto.
   *
   * @param empleado de la orden de compra.
   * @see Empleado
   */
  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> de la orden de compra.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de la orden de compra.
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
