package tech.seekback.models;

import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Definición del modelo "Departamento"
 *
 * @author veron
 */
@Entity
@Table(name = "departamento")
@NamedQueries(value = {
  @NamedQuery(name = "Departamento.getAll", query = "SELECT obj FROM Departamento obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "Departamento.getByIdPais", query = "SELECT obj FROM Departamento obj WHERE obj.pais.id = :paisId AND obj.timestamps.deleted = false")
})
public class Departamento implements Serializable {

  @Id
  @Column(name = "idDepartamento")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idPais ", nullable = false)
  private Pais pais;

  @Column(name = "nombreDepartamento", nullable = false, length = 50)
  private String nombreDepartamento;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del departamento.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del departamento.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>pais</code> del objeto.
   *
   * @return <code>pais</code> del departamento.
   * @see Pais
   */
  public Pais getPais() {
    return pais;
  }

  /**
   * Asigna el valor del atributo <code>pais</code> del objeto.
   *
   * @param pais del departamento.
   * @see Pais
   */
  public void setPais(Pais pais) {
    this.pais = pais;
  }

  /**
   * Retorna el valor del atributo <code>nombreDepartamento</code> del objeto.
   *
   * @return <code>nombreDepartamento</code> del departamento.
   */
  public String getNombreDepartamento() {
    return nombreDepartamento;
  }

  /**
   * Asigna el valor del atributo <code>nombreDepartamento</code> del objeto.
   *
   * @param nombreDepartamento del departamento.
   */
  public void setNombreDepartamento(String nombreDepartamento) {
    this.nombreDepartamento = nombreDepartamento;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> del departamento.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del departamento.
   * @see Timestamps
   */
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
    return Objects.equals(this.id, other.id);
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
