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
 * @author danny
 */
@Entity
@Table(name = "correos")
public class Correos implements Serializable {

  @Id
  @Column(name = "idCorreo")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCorreo;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
  private Usuario idUsuario;

  @Column(name = "correoElectronico", nullable = false, unique = true, length = 255)
  private String correoElectronico;

  @Column(name = "esPrincipal", nullable = false)
  private boolean esPrincipal;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdCorreo() {
    return idCorreo;
  }

  public void setIdCorreo(Integer idCorreo) {
    this.idCorreo = idCorreo;
  }

  public Usuario getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Usuario idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  public boolean getEsPrincipal() {
    return esPrincipal;
  }

  public void setEsPrincipal(boolean esPrincipal) {
    this.esPrincipal = esPrincipal;
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
    return "Correos("
            + "id = " + idCorreo + ", "
            + "idUsuario = " + idUsuario + ", "
            + "Correo = " + correoElectronico + ", "
            + "Principal = " + esPrincipal + ", "
            + timestamps.toString()
            + ")";
  }
}
