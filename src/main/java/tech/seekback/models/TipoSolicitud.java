package tech.seekback.models;

import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "TipoSolicitud")
public class TipoSolicitud extends Timestamps {

  @Id
  @Column(name = "idTipoSolicitud")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTipoSolicitud;

  @Column(name = "nombreSolicitud", length = 255, nullable = false)
  private String nombreServicio;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdTipoSolicitud() {
    return idTipoSolicitud;
  }

  public void setIdTipoSolicitud(Integer idTipoSolicitud) {
    this.idTipoSolicitud = idTipoSolicitud;
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
    return "TipoSolicitud{" 
            + "idTipoSolicitud=" + idTipoSolicitud 
            + ", nombreServicio=" + nombreServicio 
            + '}';
  }
}
