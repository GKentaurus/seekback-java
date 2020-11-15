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
import tech.seekback.dao.DivisasDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.jdbc.DBConnect;
import tech.seekback.models.Divisas;
import tech.seekback.models.templates.TablesEnum;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class DivisasDAOMySQL implements DivisasDAO {

  private static final String TABLE = TablesEnum.DIVISAS.getNombreTabla();

  @Override
  public void create() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Divisas getOne(Integer id) throws ConnectionExcep {
    try {
      PreparedStatement ps = DBConnect
              .getInstance()
              .prepareStatement(
                      "SELECT * FROM "
                      + TABLE
                      + " WHERE idDivisas = ?"
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
        ts.setDateData(rs);
        obj.setTimestamps(ts);
      }
      return obj;
    } catch (SQLException ex) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONSULTA, ex);
    }
  }

  @Override
  public List<Divisas> getAll() throws ConnectionExcep {
    List<Divisas> listaDivisas = new ArrayList<Divisas>();
    try {
      PreparedStatement ps = DBConnect
              .getInstance()
              .prepareStatement(
                      "SELECT * FROM "
                      + TABLE
              );
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        Divisas obj = new Divisas();
        obj.setIdDivisa(rs.getInt("idDivisa"));
        obj.setNombre(rs.getString("nombre"));
        obj.setSigla(rs.getString("sigla"));

        Timestamps ts = new Timestamps();
        ts.setDateData(rs);
        obj.setTimestamps(ts);
        listaDivisas.add(obj);
      }
      return listaDivisas;
    } catch (SQLException ex) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONSULTA, ex);
    }
  }

  @Override
  public void update(Divisas obj) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(Integer id) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
