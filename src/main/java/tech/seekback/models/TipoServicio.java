package tech.seekback.models;

import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "TipoServicio")
public class TipoServicio extends Timestamps {

  @Id
  @Column(name = "idTipoServicio")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTipoServicio;

  @Column(name = "nombreServicio", length = 255, nullable = false)
  private String nombreServicio;

//<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdTipoServicio() {
    return idTipoServicio;
  }

  public void setIdTipoServicio(Integer idTipoServicio) {
    this.idTipoServicio = idTipoServicio;
  }

  public String getNombreServicio() {
    return nombreServicio;
  }

  public void setNombreServicio(String nombreServicio) {
    this.nombreServicio = nombreServicio;
  }
  //</editor-fold>   

  @Override
  public String toString() {
    return "TipoServicio{" + "idTipoServicio=" 
            + idTipoServicio + ", nombreServicio=" 
            + nombreServicio 
            + '}';
  }

}
