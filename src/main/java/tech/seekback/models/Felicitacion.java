package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "felicitacion")
@NamedQueries(value = {
  @NamedQuery(name = "Felicitacion.getAll", query = "SELECT obj FROM Felicitacion obj")
})
public class Felicitacion implements Serializable {

  @Id
  @Column(name = "idFelicitacion")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idFelicitacion;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
  private Cliente idCliente;

  @Column(name = "dirigidoA", nullable = false, length = 100)
  private String dirigidoA;

  @Column(name = "comentario", nullable = true, length = 255)
  private String comentario;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdFelicitacion() {
    return idFelicitacion;
  }

  public void setIdFelicitacion(Integer idFelicitacion) {
    this.idFelicitacion = idFelicitacion;
  }

  public String getDirigidoA() {
    return dirigidoA;
  }

  public void setDirigidoA(String dirigidoA) {
    this.dirigidoA = dirigidoA;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  public Cliente getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Cliente idCliente) {
    this.idCliente = idCliente;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Felicitacion("
            + "id = " + idFelicitacion + ", "
            + "idCliente = " + idCliente + ", "
            + "dirigidoA = " + dirigidoA + ", "
            + "comentario = " + comentario + ", "
            + timestamps.toString()
            + ")";
  }
}
