package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "soporte_tecnico")
public class SoporteTecnico implements Serializable {

  @Id
  @Column(name = "idSoporteTecnico")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idSoporteTecnico;

  @Column(name = "idProducto", nullable = false)
  @ManyToOne
  private Producto idProducto;

  @Column(name = "idEstado", nullable = false)
  @ManyToOne
  private EstadosFidelizacion idEstado;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdSoporteTecnico() {
    return idSoporteTecnico;
  }

  public void setIdSoporteTecnico(Integer idSoporteTecnico) {
    this.idSoporteTecnico = idSoporteTecnico;
  }

  public Producto getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Producto idProducto) {
    this.idProducto = idProducto;
  }

  public EstadosFidelizacion getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(EstadosFidelizacion idEstado) {
    this.idEstado = idEstado;
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
    return "SoporteTecnico{"
            + "idSoporteTecnico=" + idSoporteTecnico
            + ", idProducto=" + idProducto
            + ", idEstado=" + idEstado
            + timestamps.toString()
            + '}';
  }
}
