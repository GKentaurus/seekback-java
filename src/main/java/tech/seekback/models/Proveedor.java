/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
@Entity
@Table(name = "proveedor")
@NamedQueries(value = {
  @NamedQuery(name = "Proveedor.getAll", query = "SELECT obj FROM Proveedor obj")
})
public class Proveedor implements Serializable {

  @Id
  @Column(name = "idProveedor")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idProveedor;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "tipoDoc", referencedColumnName = "idTipoDoc", nullable = false)
  private TipoDoc tipoDoc;

  @Column(name = "numeroDoc", nullable = false, length = 50)
  private String numeroDoc;

  @Column(name = "digitoVerif", nullable = false, length = 1)
  private String digitoVerif;

  @Column(name = "razonSocial", nullable = false, length = 100)
  private String razonSocial;

  @Column(name = "telefono", nullable = false, length = 20)
  private String telefono;

  @Column(name = "email", nullable = false, length = 255)
  private String email;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
  private Cliente idCliente;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdProveedor() {
    return idProveedor;
  }

  public void setIdProveedor(Integer idProveedor) {
    this.idProveedor = idProveedor;
  }

  public TipoDoc getTipoDoc() {
    return tipoDoc;
  }

  public void setTipoDoc(TipoDoc tipoDoc) {
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

  public Cliente getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Cliente idCliente) {
    this.idCliente = idCliente;
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
    return "Proveedor{"
            + "idProveedor = " + idProveedor + ", "
            + "tipoDoc = " + tipoDoc + ", "
            + "numeroDoc = " + numeroDoc + ", "
            + "digitoVerif = " + digitoVerif + ", "
            + "razonSocial = " + razonSocial + ", "
            + "telefono = " + telefono + ", "
            + "email = " + email + ", "
            + "idCliente = " + idCliente
            + timestamps.toString()
            + '}';
  }
}
