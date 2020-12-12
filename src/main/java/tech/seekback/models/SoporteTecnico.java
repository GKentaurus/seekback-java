package tech.seekback.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author veron
 */
@Entity
@Table(name = "soporte_tecnico")
@NamedQueries(value = {
  @NamedQuery(name = "SoporteTecnico.getAll", query = "SELECT obj FROM SoporteTecnico obj WHERE obj.timestamps.deleted_at IS NULL")
})
public class SoporteTecnico implements Serializable {

  @Id
  @Column(name = "idSoporteTecnico")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idProducto", nullable = false)
  private Producto producto;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idCliente", nullable = false)
  private Cliente cliente;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idEmpleado", nullable = true)
  private Empleado empleado;

  @Column(name = "comentario", nullable = false, length = 255)
  private String comentario;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idEstado", nullable = false)
  private EstadosFidelizacion estado;

  @Column(name = "fechaRespuesta", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaRespuesta;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public EstadosFidelizacion getEstado() {
    return estado;
  }

  public void setEstado(EstadosFidelizacion estado) {
    this.estado = estado;
  }

  public Timestamps getTimestamps() {
    return timestamps;
  }

  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public Date getFechaRespuesta() {
    return fechaRespuesta;
  }

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
