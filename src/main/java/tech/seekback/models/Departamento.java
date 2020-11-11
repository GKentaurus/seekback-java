package tech.seekback.models;
import tech.seekback.models.templates.Timestamps;
import javax.persistence.*;
/**
 *
 * @author veron
 */

@Entity
@Table(name="depatamento")
public class Departamento extends Timestamps{
  @Id //esto es como la PK
  @Column(name="idDepartamento")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer idDepartamento;
  
  // TODO: pendiente Llave foranea contabla pais
  @Column(name="idPais")
  private Integer idPais;
  
  @Column(name="nombreDepartamento", length = 30, nullable = false)//not null
  private String nombreDepartamento;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdDepartamento() {
    return idDepartamento;
  }

  public void setIdDepartamento(Integer idDepartamento) {
    this.idDepartamento = idDepartamento;
  }

  public Integer getIdPais() {
    return idPais;
  }

  public void setIdPais(Integer idPais) {
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
  public String toString(){
    return "Rol("
            + "id = " + idDepartamento + ", "
            + "nombreDepartamento = " + nombreDepartamento + ", "
            + super.toString() 
            + ")";
  }
}
