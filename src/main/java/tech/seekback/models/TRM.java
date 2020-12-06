package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veronica
 */
@Entity
@Table(name = "trm")
@NamedQueries(value = {
  @NamedQuery(name = "TRM.getAll", query = "SELECT obj FROM TRM obj")
})
public class TRM implements Serializable {

  @Id
  @Column(name = "idTrm")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idDivisas ", nullable = false)
  private Divisa divisa;

  @Column(name = "fechaTRM", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha;

  @Column(name = "tasaCambio", nullable = false)
  private Double tasaCambio;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Divisa getDivisa() {
    return divisa;
  }

  public void setDivisa(Divisa divisa) {
    this.divisa = divisa;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Double getTasaCambio() {
    return tasaCambio;
  }

  public void setTasaCambio(Double tasaCambio) {
    this.tasaCambio = tasaCambio;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 37 * hash + Objects.hashCode(this.id);
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
    final TRM other = (TRM) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Trm{" + "idTrm=" + id
            + ", idDivisa=" + divisa
            + ", fecha=" + fecha
            + ", tasaCambio=" + tasaCambio
            + timestamps.toString()
            + '}';
  }
}
