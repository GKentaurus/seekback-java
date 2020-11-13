package tech.seekback.models;
import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;
/**
 *
 * @author veron
 */
@Entity
@Table(name="pais")
public class Pais extends Timestamps {
  
  @Id //esto es como la PK
  @Column(name="idPais")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer idPais;
  
  @Column(name="nombrePais", nullable = false, length = 30)
  private String nombrePais;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdPais() {
    return idPais;
  }

  public void setIdPais(Integer idPais) {
    this.idPais = idPais;
  }

  public String getNombrePais() {
    return nombrePais;
  }

  public void setNombrePais(String nombrePais) {
    this.nombrePais = nombrePais;
  }
   //</editor-fold>
 
  @Override
  public String toString(){
    return "Pais("
            + "id = " + idPais + ", "
            + "nombrePais = " + nombrePais + ", "
            + super.toString() 
            + ")";
  }
}
