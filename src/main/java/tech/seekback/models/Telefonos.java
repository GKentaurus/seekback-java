package tech.seekback.models;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit;
import tech.seekback.models.templates.Timestamps;
/**
 *
 * @author veron
 */
@Entity
@Table(name = "telefonos")
public class Telefonos extends Timestamps {

  @Id
  @Column(name = "idTelefono")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTelefono;
  
  @Column(name = "idUsuario", nullable = false)
  @ManyToOne
  private Usuario idUsuario;
          
  @Column(name = "numeroTelefono", nullable = false, length = 20)
  private String numeroTelefono;
  
  @Column(name = "esPrincipal", nullable = false)
  private Boolean esPrincipal;
  
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
  //</editor-fold>

  @Override
  public String toString() {
    return "SoporteTecnico{" 
            + "idTelefono=" + idTelefono 
            + ", idUsuario=" + idUsuario 
            + ", numeroTelefono=" + numeroTelefono 
            + ", esPrincipal=" + esPrincipal 
            + super.toString() 
            + '}';
  }
  
}
