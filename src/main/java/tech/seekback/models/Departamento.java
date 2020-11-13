package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;

/**
 *
 * @author veron
 */

@Entity
@Table(name = "depatamento")
public class Departamento extends Timestamps {

  @Id //esto es como la PK
  @Column(name = "idDepartamento")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idDepartamento;

  // TODO: Revisar relación con la tabla "Pais"
  @Column(name="idPais",nullable = false)
  @ManyToOne
  private Pais idPais;

  @Column(name = "nombreDepartamento", nullable = false, length = 50)//not null
  private String nombreDepartamento;

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

  //</editor-fold>
  @Override
  public String toString() {
    return "Departamento("
            + "id = " + idDepartamento + ", "
            + "nombreDepartamento = " + nombreDepartamento + ", "
            + super.toString()
            + ")";
  }
}
