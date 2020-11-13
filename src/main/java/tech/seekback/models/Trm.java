package tech.seekback.models;

import java.util.Date;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "trm")
public class TRM extends Timestamps {

  @Id
  @Column(name = "idTrm")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTrm;

  @Column(name = "idDivisa", nullable = false)
  @ManyToOne
  private Divisas idDivisa;

  @Column(name = "fechaTRM", nullable = false)
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date fechaTRM;

  @Column(name = "tasaCambio", nullable = false)
  private Double tasaCambio;
  
//<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdTrm() {
    return idTrm;
  }

  public void setIdTrm(Integer idTrm) {
    this.idTrm = idTrm;
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
    return "Trm{" + "idTrm=" + idTrm 
            + ", idDivisa=" + idDivisa 
            + ", fechaTRM=" + fechaTRM 
            + ", tasaCambio=" + tasaCambio 
            + super.toString()
            + '}';
  }
}
