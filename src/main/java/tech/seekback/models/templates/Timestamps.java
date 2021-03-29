
package tech.seekback.models.templates;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author gkentaurus
 */
@Embeddable
public class Timestamps implements Serializable {

  @Column(name = "created_at", nullable = true, columnDefinition = "CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created_at;

  @Column(name = "updated_at", nullable = true, columnDefinition = "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updated_at;

  @Column(name = "deleted", nullable = true, columnDefinition = "NULL")
  private boolean deleted;

  @Column(name = "deleted_at", nullable = true, columnDefinition = "NULL")
  @Temporal(TemporalType.TIMESTAMP)
  private Date deleted_at;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>created_at</code> del objeto.
   *
   * @return <code>created_at</code> de los timestamps del respectivo objeto.
   */
  public Date getCreated_at() {
    return created_at;
  }

  /**
   * Asigna el valor del atributo <code>created_at</code> del objeto.
   *
   * @param created_at de los timestamps del respectivo objeto.
   */
  public void setCreated_at(Date created_at) {
    this.created_at = created_at;
  }

  /**
   * Retorna el valor del atributo <code>updated_at</code> del objeto.
   *
   * @return <code>updated_at</code> de los timestamps del respectivo objeto.
   */
  public Date getUpdated_at() {
    return updated_at;
  }

  /**
   * Asigna el valor del atributo <code>updated_at</code> del objeto.
   *
   * @param updated_at de los timestamps del respectivo objeto.
   */
  public void setUpdated_at(Date updated_at) {
    this.updated_at = updated_at;
  }

  /**
   * Retorna el valor del atributo <code>deleted</code> del objeto.
   *
   * @return <code>deleted</code> de los timestamps del respectivo objeto.
   */
  public boolean getDeleted() {
    return deleted;
  }

  /**
   * Asigna el valor del atributo <code>deleted</code> del objeto.
   *
   * @param deleted de los timestamps del respectivo objeto.
   */
  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  /**
   * Retorna el valor del atributo <code>deleted_at</code> del objeto.
   *
   * @return <code>deleted_at</code> de los timestamps del respectivo objeto.
   */
  public Date getDeleted_at() {
    return deleted_at;
  }

  /**
   * Asigna el valor del atributo <code>deleted_at</code> del objeto.
   *
   * @param deleted_at de los timestamps del respectivo objeto.
   */
  public void setDeleted_at(Date deleted_at) {
    this.deleted_at = deleted_at;
  }

  public void resetDeleted_at() {
    this.deleted_at = null;
  }
  //</editor-fold>

  /**
   * Asigna el valor de los atributos <code>created_at</code>,
   * <code>updated_at</code> y <code>deleted_at</code> del objeto respectivo.
   *
   * @param rs de la petición para almacenar en la base de datos.
   */
  public void setDateData(ResultSet rs) throws SQLException {
    this.created_at = rs.getDate("created_at");
    this.updated_at = rs.getDate("updated_at");
    this.deleted = rs.getBoolean("deleted");
    this.deleted_at = rs.getDate("deleted_at");
  }

  @Override
  /**
   * Retorna una cadena de caracteres de que resume toda la información
   * relevante del objeto.
   *
   * @return <code>String compilado</code> del objeto.
   */
  public String toString() {
    return "created_at = " + created_at + ", "
      + "updated_at = " + updated_at + ", "
      + "deleted = " + deleted + ", "
      + "deleted at = " + deleted_at;
  }

}
