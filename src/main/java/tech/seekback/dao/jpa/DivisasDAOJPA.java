/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

<<<<<<< HEAD
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tech.seekback.dao.DivisasDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.jdbc.DBConnect;
import tech.seekback.models.Divisas;
<<<<<<< HEAD:src/main/java/tech/seekback/dao/mysql/DivisasDAOMySQL.java
import tech.seekback.models.TipoDoc;
import tech.seekback.models.templates.TablesEnum;
import tech.seekback.models.templates.Timestamps;
=======
import tech.seekback.models.templates.TablesEnum;
>>>>>>> master:src/main/java/tech/seekback/dao/jpa/DivisasDAOJPA.java
=======
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.DivisasDAO;
import tech.seekback.models.Divisas;
>>>>>>> master

/**
 *
 * @author camorenoc
 */
public class DivisasDAOJPA extends GenericDAO<Divisas, Integer> implements DivisasDAO {

<<<<<<< HEAD
  private static final String TABLE = TablesEnum.DIVISAS.getNombreTabla();

  @Override
  public void create() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Divisas getOne(Integer id) throws ConnectionExcep {
    try {
      PreparedStatement ps = DBConnect.getInstance().prepareStatement(
              "SELECT * FROM "
              + TablesEnum.DIVISAS.getNombreTabla()
              + " WHERE idDivisa = ?"
      );
      ps.setInt(1, id);

      ResultSet rs = ps.executeQuery();

      Divisas obj = null;
      Timestamps ts = null;

      if (rs.next()) {
        obj = new Divisas();

        obj.setIdDivisa(rs.getInt("idDivisa"));
        obj.setNombre(rs.getString("nombre"));
        obj.setSigla(rs.getString("sigla"));

        ts = new Timestamps();

        ts.setCreated_at(rs.getDate("created_at"));
        ts.setUpdated_at(rs.getDate("updated_at"));
        ts.setDeleted_at(rs.getDate("deleted_at"));

        obj.setTimestamps(ts);

      }

      return obj;

    } catch (SQLException ex) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONSULTA, ex);
    }
  }

  @Override
  public List<Divisas> getAll() throws ConnectionExcep {
    try {
      List<Divisas> listaDivisas = new ArrayList<Divisas>();

      PreparedStatement ps = DBConnect.getInstance().prepareStatement(
              "SELECT * FROM "
              + TablesEnum.DIVISAS.getNombreTabla()
      );

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {

        Divisas obj = null;
        Timestamps ts = null;

        obj = new Divisas();

        obj.setIdDivisa(rs.getInt("idDivisa"));
        obj.setNombre(rs.getString("nombre"));
        obj.setSigla(rs.getString("sigla"));

        ts = new Timestamps();

        ts.setCreated_at(rs.getDate("created_at"));
        ts.setUpdated_at(rs.getDate("updated_at"));
        ts.setDeleted_at(rs.getDate("deleted_at"));

        obj.setTimestamps(ts);

        listaDivisas.add(obj);

      }

      return listaDivisas;

    } catch (SQLException ex) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONSULTA, ex);
    }
=======
  public DivisasDAOJPA() {
    super(Divisas.class);
>>>>>>> master
  }
}
