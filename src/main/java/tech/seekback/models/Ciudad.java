
package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.util.Objects;

/**
 * Definición del modelo "Ciudad"
 *
 * @author camorenoc
 */
@Entity
@Table(name = "ciudad")
@NamedQueries(value = {
  @NamedQuery(name = "Ciudad.getAll", query = "SELECT obj FROM Ciudad obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "Ciudad.getByIdDepartamento", query = "SELECT obj FROM Ciudad obj WHERE obj.departamento.id = :DepartamentoId AND obj.timestamps.deleted = false")
})
public class Ciudad implements EntityTimestamp {

  @Id
  @Column(name = "idCiudad")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idDepartamento", nullable = false)
  private Departamento departamento;

  @Column(name = "nombreCiudad", nullable = false, length = 50)
  private String nombreCiudad;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> de la ciudad.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id de la ciudad.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>departamento</code> del objeto.
   *
   * @return <code>departamento</code> de la ciudad.
   * @see Departamento
   */
  public Departamento getDepartamento() {
    return departamento;
  }

  /**
   * Asigna el valor del atributo <code>departamento</code> del objeto.
   *
   * @param departamento de la ciudad.
   * @see Departamento
   */
  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  /**
   * Retorna el valor del atributo <code>nombreCiudad</code> del objeto.
   *
   * @return <code>nombreCiudad</code> de la ciudad.
   */
  public String getNombreCiudad() {
    return nombreCiudad;
  }

  /**
   * Asigna el valor del atributo <code>nombreCiudad</code> del objeto.
   *
   * @param nombreCiudad de la ciudad.
   */
  public void setNombreCiudad(String nombreCiudad) {
    this.nombreCiudad = nombreCiudad;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> de la ciudad.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps de la ciudad.
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
    final Ciudad other = (Ciudad) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Ciudad{"
      + "id = " + id + ", "
      + "fepartamento = " + departamento + ", "
      + "nombreCiudad = " + nombreCiudad + ", "
      + timestamps.toString()
      + '}';
  }

}
