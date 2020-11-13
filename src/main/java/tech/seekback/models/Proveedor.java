package tech.seekback.models;

import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "Proveedor")
public class Proveedor extends Timestamps {

  @Id
  @Column(name = "idProveedor")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idProveedor;

  @Column(name = "tipoDoc", length = 255, nullable = false)
  private Integer tipoDoc;

  @Column(name = "numeroDoc", length = 255, nullable = false)
  private String numeroDoc;

  @Column(name = "digitoVerif", length = 255, nullable = false)
  private String digitoVerif;

  @Column(name = "razonSocial", length = 255, nullable = false)
  private String razonSocial;

  @Column(name = "telefono", length = 255, nullable = false)
  private String telefono;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "idCliente", nullable = false)
  private String idCliente;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters"> 
  public Integer getIdProveedor() {
    return idProveedor;
  }

  public void setIdProveedor(Integer idProveedor) {
    this.idProveedor = idProveedor;
  }

  public Integer getTipoDoc() {
    return tipoDoc;
  }

  public void setTipoDoc(Integer tipoDoc) {
    this.tipoDoc = tipoDoc;
  }

  public String getNumeroDoc() {
    return numeroDoc;
  }

  public void setNumeroDoc(String numeroDoc) {
    this.numeroDoc = numeroDoc;
  }

  public String getDigitoVerif() {
    return digitoVerif;
  }

  public void setDigitoVerif(String digitoVerif) {
    this.digitoVerif = digitoVerif;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(String idCliente) {
    this.idCliente = idCliente;
  }
  //</editor-fold> 

  @Override
  public String toString() {
    return "Proveedor{" + "idProveedor=" + idProveedor 
            + ", tipoDoc=" + tipoDoc 
            + ", numeroDoc=" + numeroDoc 
            + ", digitoVerif=" + digitoVerif 
            + ", razonSocial=" + razonSocial 
            + ", telefono=" + telefono 
            + ", email=" + email 
            + ", idCliente=" + idCliente 
            + '}';
  }

}
