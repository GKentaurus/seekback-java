package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

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
   * @see Proveedor
   * @return <code>proveedor</code> de la orden de compra.
   */
  public Proveedor getProveedor() {
    return proveedor;
  }

  /**
   * Asigna el valor del atributo <code>proveedor</code> del objeto.
   *
   * @see Proveedor
   * @param proveedor de la orden de compra.
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
   * @see TRM
   * @return <code>trm</code> de la orden de compra.
   */
  public TRM getTrm() {
    return trm;
  }

  /**
   * Asigna el valor del atributo <code>trm</code> del objeto.
   *
   * @see TRM
   * @param trm de la orden de compra.
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
   * @see Empleado
   * @return <code>factorImport</code> de la orden de compra.
   */
  public Empleado getEmpleado() {
    return empleado;
  }

  /**
   * Asigna el valor del atributo <code>factorImport</code> del objeto.
   *
   * @see Empleado
   * @param empleado de la orden de compra.
   */
  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> de la orden de compra.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps de la orden de compra.
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
