package tech.seekback.models;

import java.util.Date;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "OrdenCompra")
public class OrdenCompra extends Timestamps {

  @Id
  @Column(name = "idOrdenCompra")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idOrdenCompra;

  @Column(name = "idProveedor", nullable = false)
  private Integer idProveedor;

  @Column(name = "fecha", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fecha;

  @Column(name = "docAsociado", length = 255, nullable = false)
  private String docAsociado;
  
  @Column(name = "idTrm",  nullable = false)
  private Integer idTrm;
  
  //TODO: este valor es un double y hay que?
  @Column(name = "factorImport",  nullable = false)
  private Double factorImport;
  
  @Column(name = "idEmpleado", nullable = false)
  private Integer idEmpleado;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters"> 
  public Integer getidOrdenCompra() {
    return idOrdenCompra;
  }

  public void setIdOrdenCompra(Integer idordenCompra) {
    this.idOrdenCompra = idOrdenCompra;
  }

  public Integer getIdproveedor() {
    return idProveedor;
  }

  public void setIdproveedor(Integer idProveedor) {
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

  public Integer getIdTrm() {
    return idTrm;
  }

  public void setIdTrm(Integer idTrm) {
    this.idTrm = idTrm;
  }

  public Double getFactorImport() {
    return factorImport;
  }

  public void setFactorImport(Double factorImport) {
    this.factorImport = factorImport;
  }

  public Integer getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Integer idEmpleado) {
    this.idEmpleado = idEmpleado;
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
            + ")";
  }
  
}
