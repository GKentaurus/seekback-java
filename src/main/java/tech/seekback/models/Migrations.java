package tech.seekback.models;

import javax.persistence.*;
import tech.seekback.models.templates.Timestamps;
/**
 *
 * @author veron
 */
@Entity
@Table(name = "Migrations")
public class Migrations extends Timestamps{
  @Id
  @Column(name = "idMigrations")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idMigrations;
  
  @Column(name = "migrations", nullable = false)
  private String migrations;
  
  @Column(name = "batch", length = 255, nullable = false)
  private Integer batch;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdMigrations() {
    return idMigrations;
  }

  public void setIdMigrations(Integer idMigrations) {
    this.idMigrations = idMigrations;
  }

  public String getMigrations() {
    return migrations;
  }

  public void setMigrations(String migrations) {
    this.migrations = migrations;
  }

  public Integer getBatch() {
    return batch;
  }

  public void setBatch(Integer batch) {
    this.batch = batch;
  }
  
  //</editor-fold> 

  @Override
  public String toString() {
    return "Migrations("
            + "id = " + idMigrations + ", "
            + "migrations = " + migrations + ", "
            + "batch = " + batch + ", "
            + ")";
  }
}
