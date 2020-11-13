package tech.seekback.models;
import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;
/**
 *
 * @author veron
 */
@Entity
@Table(name = "SoporteTecnico")
public class SoporteTecnico extends Timestamps{

  @Id
  @Column(name = "idSoporteTecnico")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idSoporteTecnico;

  @Column(name = "idProducto",nullable = false)
  private Integer idProducto;

  @Column(name = "idEstado",nullable = false)
  private String idEstado;

  
//<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdSoporteTecnico() {
    return idSoporteTecnico;
  }

  public void setIdSoporteTecnico(Integer idSoporteTecnico) {
    this.idSoporteTecnico = idSoporteTecnico;
  }

  public Integer getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Integer idProducto) {
    this.idProducto = idProducto;
  }

  public String getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(String idEstado) {
    this.idEstado = idEstado;
  }
 //</editor-fold>   

  @Override
  public String toString() {
    return "SoporteTecnico{" 
            + "idSoporteTecnico=" + idSoporteTecnico 
            + ", idProducto=" + idProducto 
            + ", idEstado=" + idEstado 
            + '}';
  }
}
