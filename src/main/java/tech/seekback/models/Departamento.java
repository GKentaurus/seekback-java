package tech.seekback.models;

import java.io.Serializable;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "depatamento")
public class Departamento implements Serializable {

  @Id //esto es como la PK
  @Column(name = "idDepartamento")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idDepartamento;

  @Column(name = "idPais", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idPais ", referencedColumnName = "idPais")
  private Pais idPais;

  @Column(name = "nombreDepartamento", nullable = false, length = 50)//not null
  private String nombreDepartamento;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdDepartamento() {
    return idDepartamento;
  }

  public void setIdDepartamento(Integer idDepartamento) {
    this.idDepartamento = idDepartamento;
  }

  public Pais getIdPais() {
    return idPais;
  }

  public void setIdPais(Pais idPais) {
    this.idPais = idPais;
  }

  public String getNombreDepartamento() {
    return nombreDepartamento;
  }

  public void setNombreDepartamento(String nombreDepartamento) {
    this.nombreDepartamento = nombreDepartamento;
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
    return "Departamento("
            + "id = " + idDepartamento + ", "
            + "nombreDepartamento = " + nombreDepartamento + ", "
            + timestamps.toString()
            + ")";
  }
}
