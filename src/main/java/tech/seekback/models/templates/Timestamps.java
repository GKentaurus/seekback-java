/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.models.templates;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author camorenoc
 */
@Embeddable
public class Timestamps implements Serializable {

  @Column(name = "created_at", nullable = true, columnDefinition = "CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created_at;

  @Column(name = "updated_at", nullable = true, columnDefinition = "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updated_at;

  @Column(name = "deleted_at", nullable = true, columnDefinition = "NULL")
  @Temporal(TemporalType.TIMESTAMP)
  private Date deleted_at;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Date getCreated_at() {
    return created_at;
  }

  public void setCreated_at(Date created_at) {
    this.created_at = created_at;
  }

  public Date getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(Date updated_at) {
    this.updated_at = updated_at;
  }

  public Date getDeleted_at() {
    return deleted_at;
  }

  public void setDeleted_at(Date deleted_at) {
    this.deleted_at = deleted_at;
  }

  public void setDateData(ResultSet rs) throws SQLException {
    this.created_at = rs.getDate("created_at");
    this.updated_at = rs.getDate("updated_at");
    this.deleted_at = rs.getDate("deleted_at");
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "created_at = " + created_at + ", "
            + "updated_at = " + updated_at + ", "
            + "deleted at = " + deleted_at;
  }

}
