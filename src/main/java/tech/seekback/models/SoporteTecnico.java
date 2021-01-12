package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 * Definición del modelo "SoporteTecnico"
 *
 * @author veron
 */
@Entity
@Table(name = "soporte_tecnico")
@NamedQueries(value = {
  @NamedQuery(name = "SoporteTecnico.getAll", query = "SELECT obj FROM SoporteTecnico obj WHERE obj.timestamps.deleted = false"),
  @NamedQuery(name = "SoporteTecnico.getAllCount", query = "SELECT COUNT(obj) FROM SoporteTecnico obj WHERE obj.timestamps.deleted = false")
})
public class SoporteTecnico implements Serializable {

  @Id
  @Column(name = "idSoporteTecnico")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idProducto", nullable = false)
  private Producto producto;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idCliente", nullable = false)
  private Cliente cliente;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idEmpleado", nullable = true)
  private Empleado empleado;

  @Column(name = "comentario", nullable = false, length = 255)
  private String comentario;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idEstado", nullable = false)
  private EstadosFidelizacion estado;

  @Column(name = "fechaRespuesta", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaRespuesta;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del soporte técnico.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del soporte técnico.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>producto</code> del objeto.
   *
   * @see Producto
   * @return <code>producto</code> del soporte técnico.
   */
  public Producto getProducto() {
    return producto;
  }

  /**
   * Asigna el valor del atributo <code>producto</code> del objeto.
   *
   * @see Producto
   * @param producto del soporte técnico.
   */
  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  /**
   * Retorna el valor del atributo <code>estado</code> del objeto.
   *
   * @see EstadosFidelizacion
   * @return <code>estado</code> del soporte técnico.
   */
  public EstadosFidelizacion getEstado() {
    return estado;
  }

  /**
   * Asigna el valor del atributo <code>estado</code> del objeto.
   *
   * @see EstadosFidelizacion
   * @param estado del soporte técnico.
   */
  public void setEstado(EstadosFidelizacion estado) {
    this.estado = estado;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @return <code>timestamps</code> del soporte técnico.
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Timestamps
   * @param timestamps del soporte técnico.
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Cliente
   * @return <code>timestamps</code> del soporte técnico.
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @see Cliente
   * @param cliente del soporte técnico.
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * Retorna el valor del atributo <code>empleado</code> del objeto.
   *
   * @see Empleado
   * @return <code>empleado</code> del soporte técnico.
   */
  public Empleado getEmpleado() {
    return empleado;
  }

  /**
   * Asigna el valor del atributo <code>empleado</code> del objeto.
   *
   * @see Empleado
   * @param empleado del soporte técnico.
   */
  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  /**
   * Retorna el valor del atributo <code>comentario</code> del objeto.
   *
   * @return <code>comentario</code> del soporte técnico.
   */
  public String getComentario() {
    return comentario;
  }

  /**
   * Asigna el valor del atributo <code>comentario</code> del objeto.
   *
   * @param comentario del soporte técnico.
   */
  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  /**
   * Retorna el valor del atributo <code>fechaRespuesta</code> del objeto.
   *
   * @return <code>fechaRespuesta</code> del soporte técnico.
   */
  public Date getFechaRespuesta() {
    return fechaRespuesta;
  }

  /**
   * Asigna el valor del atributo <code>fechaRespuesta</code> del objeto.
   *
   * @param fechaRespuesta del soporte técnico.
   */
  public void setFechaRespuesta(Date fechaRespuesta) {
    this.fechaRespuesta = fechaRespuesta;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.id);
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
    final SoporteTecnico other = (SoporteTecnico) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  //</editor-fold>

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
  public String toString() {
    return "SoporteTecnico{"
            + "id = " + id + ", "
            + "producto = " + producto + ", "
            + "cliente = " + cliente + ", "
            + "empleado = " + empleado + ", "
            + "comentario = " + comentario + ", "
            + "estado = " + estado + ", "
            + "fechaRespuesta = " + fechaRespuesta + ", "
            + timestamps.toString()
            + '}';
  }
}
