package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "TRM"
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
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la TRM.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la TRM.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>divisa</code> del objeto.
   *
   * @see Divisa
   * @return <code>divisa</code> de la TRM.
   */
  public Divisa getDivisa() {
    return divisa;
  }

  /**
   * Asigna el valor del atributo <code>divisa</code> del objeto.
   *
   * @see Divisa
   * @param divisa de la TRM.
   */
  public void setDivisa(Divisa divisa) {
    this.divisa = divisa;
  }

  /**
   * Retorna el valor del atributo <code>fecha</code> del objeto.
   *
   * @return <code>fecha</code> de la TRM.
   */
  public Date getFecha() {
    return fecha;
  }

  /**
   * Asigna el valor del atributo <code>fecha</code> del objeto.
   *
   * @param fecha de la TRM.
   */
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  /**
   * Retorna el valor del atributo <code>tasaCambio</code> del objeto.
   *
   * @return <code>tasaCambio</code> de la TRM.
   */
  public Double getTasaCambio() {
    return tasaCambio;
  }

  /**
   * Asigna el valor del atributo <code>tasaCambio</code> del objeto.
   *
   * @param tasaCambio de la TRM.
   */
  public void setTasaCambio(Double tasaCambio) {
    this.tasaCambio = tasaCambio;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> de la TRM.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps de la TRM.
   */
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
  /**
   * Retorna una cadena de caracteres de que resume toda la información
   * relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
  public String toString() {
    return "Trm{" + "idTrm=" + id
            + ", idDivisa=" + divisa
            + ", fecha=" + fecha
            + ", tasaCambio=" + tasaCambio
            + timestamps.toString()
            + '}';
  }
}
