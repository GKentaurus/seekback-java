package tech.seekback.models;

import java.io.Serializable;
import java.util.Objects;
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
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idCliente", nullable = false)
  private Cliente cliente;

  @Column(name = "dirigidoA", nullable = false, length = 100)
  private String dirigidoA;

  @Column(name = "comentario", nullable = true, length = 255)
  private String comentario;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + Objects.hashCode(this.id);
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
    final Felicitacion other = (Felicitacion) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Felicitacion("
            + "id = " + id + ", "
            + "cliente = " + cliente + ", "
            + "dirigidoA = " + dirigidoA + ", "
            + "comentario = " + comentario + ", "
            + timestamps.toString()
            + ")";
  }
}
