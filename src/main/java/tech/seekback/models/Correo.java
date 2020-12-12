/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "Correo"
 *
 * @author danny
 */
@Entity
@Table(name = "correos")
@NamedQueries(value = {
  @NamedQuery(name = "Correo.getAll", query = "SELECT obj FROM Correo obj WHERE obj.timestamps.deleted_at IS NULL"),
  @NamedQuery(name = "Correo.getByCorreo", query = "SELECT obj FROM Correo obj WHERE obj.correoElectronico = :CorreoRec"),
  @NamedQuery(name = "Correo.getByIdPrincipal", query = "SELECT obj FROM Correo obj WHERE obj.usuario.id = :idUsuario AND obj.esPrincipal = 1")
})
public class Correo implements Serializable {

  @Id
  @Column(name = "idCorreo")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idUsuario", nullable = false)
  private Usuario usuario;

  @Column(name = "correoElectronico", nullable = false, unique = true, length = 255)
  private String correoElectronico;

  @Column(name = "esPrincipal", nullable = false)
  private boolean esPrincipal;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del correo.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del correo.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>usuario</code> del objeto.
   *
   * @see Usuario
   * @return <code>usuario</code> del correo.
   */
  public Usuario getUsuario() {
    return usuario;
  }

  /**
   * Asigna el valor del atributo <code>usuario</code> del objeto.
   *
   * @see Usuario
   * @param usuario del correo.
   */
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  /**
   * Retorna el valor del atributo <code>correoElectronico</code> del objeto.
   *
   * @return <code>correoElectronico</code> del correo.
   */
  public String getCorreoElectronico() {
    return correoElectronico;
  }

  /**
   * Asigna el valor del atributo <code>correoElectronico</code> del objeto.
   *
   * @param correoElectronico del correo.
   */
  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  /**
   * Retorna el valor del atributo <code>esPrincipal</code> del objeto.
   *
   * @return <code>esPrincipal</code> del correo.
   */
  public boolean getEsPrincipal() {
    return esPrincipal;
  }

  /**
   * Asigna el valor del atributo <code>esPrincipal</code> del objeto.
   *
   * @param esPrincipal del correo.
   */
  public void setEsPrincipal(Boolean esPrincipal) {
    this.esPrincipal = esPrincipal;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> del correo.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps del correo.
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 47 * hash + Objects.hashCode(this.id);
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
    final Correo other = (Correo) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información
   * relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
  public String toString() {
    return "Correos("
            + "id = " + id + ", "
            + "usuario = " + usuario + ", "
            + "correo = " + correoElectronico + ", "
            + "principal = " + esPrincipal + ", "
            + timestamps.toString()
            + ")";
  }
}
