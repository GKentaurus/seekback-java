/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "telefonos")
public class Telefonos extends Timestamps {

  @Id
  @Column(name = "idTelefono")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTelefono;

  // TODO: Revisar relación con la tabla "Usuario"
  @Column(name = "idUsuario", nullable = false)
  @ManyToOne
  private Usuario idUsuario;

  @Column(name = "numeroTelefono", length = 20, nullable = false)
  private String numeroTelefono;

  @Column(name = "esPrincipal", nullable = false)
  private boolean esPrincipal;

  //TODO:  se debe revisar al crear las clases pendientes
  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdCorreo() {
    return idTelefono;
  }

  public void setIdCorreo(Integer idCorreo) {
    this.idTelefono = idCorreo;
  }

  public Usuario getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Usuario idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getNumeroTelefono() {
    return numeroTelefono;
  }

  public void setNumeroTelefono(String numeroTelefono) {
    this.numeroTelefono = numeroTelefono;
  }

  public boolean getEsPrincipal() {
    return esPrincipal;
  }

  public void setEsPrincipal(boolean esPrincipal) {
    this.esPrincipal = esPrincipal;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Correos("
            + "id = " + idTelefono + ", "
            + "idUsuario = " + idUsuario + ", "
            + "Telefono = " + numeroTelefono + ", "
            + "Principal = " + esPrincipal + ", "
            + super.toString()
            + ")";
  }

}
