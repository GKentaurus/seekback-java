/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tech.seekback.dao.PaisDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.jdbc.DBConnect;
import tech.seekback.models.Pais;
import tech.seekback.models.templates.TablesEnum;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class PaisDAOMySQL implements PaisDAO {

  private static final String TABLE = TablesEnum.PAIS.getNombreTabla();

  @Override
  public void create() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Pais getOne(Integer id) throws ConnectionExcep {
    try {
      PreparedStatement ps = DBConnect
              .getInstance()
              .prepareStatement(
                      "SELECT * FROM "
                      + TABLE
                      + " WHERE idPais = ?"
              );
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      Pais obj = null;
      Timestamps ts = null;

      if (rs.next()) {
        obj = new Pais();
        obj.setIdPais(rs.getInt("idPais"));
        obj.setNombrePais(rs.getString("nombrePais"));

        ts = new Timestamps();
        ts.setDateData(rs);
        obj.setTimestamps(ts);
      }
      return obj;
    } catch (SQLException ex) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONSULTA, ex);
    }
  }

  @Override
  public List<Pais> getAll() throws ConnectionExcep {
    List<Pais> list = new ArrayList<Pais>();
    try {
      PreparedStatement ps = DBConnect
              .getInstance()
              .prepareStatement(
                      "SELECT * FROM "
                      + TABLE
              );
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Pais obj = new Pais();
        Timestamps ts = new Timestamps();

        obj.setIdPais(rs.getInt("idPais"));
        obj.setNombrePais(rs.getString("nombrePais"));
        ts.setDateData(rs);
        obj.setTimestamps(ts);
        list.add(obj);
      }
      return list;
    } catch (SQLException ex) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONSULTA, ex);
    }
  }

  @Override
  public void update(Pais obj) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(Integer id) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
