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
@Table(name = "departamento")
@NamedQueries(value = {
  @NamedQuery(name = "Departamento.getAll", query = "SELECT obj FROM Departamento obj"),
  @NamedQuery(name = "Departamento.getByIdPais", query = "SELECT obj FROM Departamento obj WHERE obj.pais.id = :paisId")
})
public class Departamento implements Serializable {

  @Id
  @Column(name = "idDepartamento")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idPais ", nullable = false)
  private Pais pais;

  @Column(name = "nombreDepartamento", nullable = false, length = 50)
  private String nombreDepartamento;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Pais getPais() {
    return pais;
  }

  public void setPais(Pais pais) {
    this.pais = pais;
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

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 29 * hash + Objects.hashCode(this.id);
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
    final Departamento other = (Departamento) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Departamento("
            + "id = " + id + ", "
            + "nombreDepartamento = " + nombreDepartamento + ", "
            + timestamps.toString()
            + ")";
  }
}
