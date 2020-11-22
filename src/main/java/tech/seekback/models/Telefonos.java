package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "telefonos")
@NamedQueries(value = {
  @NamedQuery(name = "Telefonos.getAll", query = "SELECT obj FROM Telefonos obj")
})
public class Telefonos implements Serializable {

  @Id
  @Column(name = "idTelefono")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idUsuario", nullable = false)
  private Usuario usuario;

  @Column(name = "numeroTelefono", nullable = false, length = 20)
  private String numeroTelefono;

  @Column(name = "esPrincipal", nullable = false)
  private Boolean esPrincipal;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public String getNumeroTelefono() {
    return numeroTelefono;
  }

  public void setNumeroTelefono(String numeroTelefono) {
    this.numeroTelefono = numeroTelefono;
  }

  public Boolean getEsPrincipal() {
    return esPrincipal;
  }

  public void setEsPrincipal(Boolean esPrincipal) {
    this.esPrincipal = esPrincipal;
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
            + "idTelefono=" + id + ", "
            + "idUsuario=" + usuario + ", "
            + "numeroTelefono=" + numeroTelefono + ", "
            + "esPrincipal=" + esPrincipal + ", "
            + timestamps.toString()
            + '}';
  }

}
