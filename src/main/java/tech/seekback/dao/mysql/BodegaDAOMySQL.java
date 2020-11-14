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
import tech.seekback.dao.BodegaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.jdbc.DBConnect;
import tech.seekback.models.Bodega;
import tech.seekback.models.templates.TablesEnum;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class BodegaDAOMySQL implements BodegaDAO {

  @Override
  public void create() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Bodega getOne(Integer id) throws ConnectionExcep {
    try {
      PreparedStatement ps = DBConnect
              .getInstance()
              .prepareStatement(
                      "SELECT * FROM "
                      + TablesEnum.BODEGA
                      + " WHERE idBodega = ?"
              );
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      Bodega obj = null;
      Timestamps ts = null;
      if (rs.next()) {
        obj = new Bodega();
        obj.setIdBodega(rs.getInt("idBodega"));
        obj.setNombreBodega(rs.getString("nombreBodega"));

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
  public List<Bodega> getAll() throws ConnectionExcep {
    List<Bodega> listaBodegas = new ArrayList<Bodega>();
    try {
      PreparedStatement ps = DBConnect.getInstance()
              .prepareStatement("SELECT * FROM " + TablesEnum.BODEGA);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Bodega obj = new Bodega();
        Timestamps ts = new Timestamps();
        obj.setIdBodega(rs.getInt("idBodega"));
        obj.setNombreBodega(rs.getString("nombreBodega"));

        ts.setCreated_at(rs.getDate("created_at"));
        ts.setUpdated_at(rs.getDate("updated_at"));
        ts.setDeleted_at(rs.getDate("deleted_at"));

        obj.setTimestamps(ts);
        listaBodegas.add(obj);
      }
      return listaBodegas;
    } catch (SQLException ex) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONSULTA, ex);
    }
  }

  @Override
  public void update(Bodega obj) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(Integer id) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
