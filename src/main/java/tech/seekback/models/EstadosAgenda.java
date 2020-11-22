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
@Table(name = "estados_agenda")
@NamedQueries(value = {
  @NamedQuery(name = "EstadosAgenda.getAll", query = "SELECT obj FROM EstadosAgenda obj")
})
public class EstadosAgenda implements Serializable {

  @Id
  @Column(name = "idEstado")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombreEstado", nullable = false, length = 30)
  private String nombreEstado;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombreEstado() {
    return nombreEstado;
  }

  public void setNombreEstado(String nombreEstado) {
    this.nombreEstado = nombreEstado;
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
    return "EstadoAgenda("
            + "id = " + id + ", "
            + "nombreEstado = " + nombreEstado + ", "
            + timestamps.toString()
            + ")";
  }

}
