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
public class Telefonos implements Serializable {

  @Id
  @Column(name = "idTelefono")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTelefono;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
  private Usuario idUsuario;

  @Column(name = "numeroTelefono", nullable = false, length = 20)
  private String numeroTelefono;

  @Column(name = "esPrincipal", nullable = false)
  private Boolean esPrincipal;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdTelefono() {
    return idTelefono;
  }

  public void setIdTelefono(Integer idTelefono) {
    this.idTelefono = idTelefono;
  }

  public Usuario getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Usuario idUsuario) {
    this.idUsuario = idUsuario;
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
            + "idTelefono=" + idTelefono
            + ", idUsuario=" + idUsuario
            + ", numeroTelefono=" + numeroTelefono
            + ", esPrincipal=" + esPrincipal
            + timestamps.toString()
            + '}';
  }

}
