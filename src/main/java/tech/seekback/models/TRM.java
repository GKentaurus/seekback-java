/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models;

import java.util.Date;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author gkent
 */
@Entity
@Table(name = "trm")
public class TRM extends Timestamps {

  @Id
  @Column(name = "idTRM")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTRM;

  @Column(name = "idDivisa", nullable = false)
  @ManyToOne
  private Divisas idDivisa;

  @Column(name = "fechaTRM", nullable = false)
  private Date fechaTRM;

  @Column(name = "tasaCambio", nullable = false)
  private Double tasaCambio;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdTRM() {
    return idTRM;
  }

  public void setIdTRM(Integer idTRM) {
    this.idTRM = idTRM;
  }

  public Divisas getIdDivisa() {
    return idDivisa;
  }

  public void setIdDivisa(Divisas idDivisa) {
    this.idDivisa = idDivisa;
  }

  public Date getFechaTRM() {
    return fechaTRM;
  }

  public void setFechaTRM(Date fechaTRM) {
    this.fechaTRM = fechaTRM;
  }

  public Double getTasaCambio() {
    return tasaCambio;
  }

  public void setTasaCambio(Double tasaCambio) {
    this.tasaCambio = tasaCambio;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "TRM{"
            + "idTRM = " + idTRM + ", "
            + "idDivisa = " + idDivisa + ", "
            + "fechaTRM = " + fechaTRM + ", "
            + "tasaCambio = " + tasaCambio
            + super.toString()
            + '}';
  }
}
