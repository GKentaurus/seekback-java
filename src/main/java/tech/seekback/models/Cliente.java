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
@Table(name = "cliente")
public class Cliente extends Timestamps {

  @Id
  @Column(name = "idCliente")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCliente;
  
  @Column(name = "idUsuario", nullable = false)
  @ManyToOne
  private Integer idUsuario;
  
  
 //TODO:  se debe revisar al crear las clases pendientes
  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">  

  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }
  //</editor-fold>
  
  
  @Override
  public String toString(){
    return "CategoriasProducto("
            + "id = " + idCliente + ", "
            + "idUsuario = " + idUsuario + ", "
            + super.toString() 
            + ")";
  }  
  
}
