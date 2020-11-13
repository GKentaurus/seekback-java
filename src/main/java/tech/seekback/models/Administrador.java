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
@Table(name="administrador")
public class Administrador extends Timestamps{

  @Id
  @Column(name="idAdministrador")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idAdministrador;
  
  
  // TODO: Revisar relación con la tabla "Usuario"
  @Column(name = "idUsuario", nullable = false)
  @ManyToOne
  private Usuario idUsuario;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdAdministrador() {
    return idAdministrador;
  }

  public void setIdAdministrador(Integer idAdministrador) {
    this.idAdministrador = idAdministrador;
  }

  public Usuario getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Usuario idUsuario) {
    this.idUsuario = idUsuario;
  }
  //</editor-fold>
    
  @Override
  public String toString(){
    return "Administrador("
            + "id = " + idAdministrador + ", "
            + "idUsuario = " + idUsuario + ", "
            + super.toString() 
            + ")";
  }  
  
}