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
import tech.seekback.dao.EstadosAgendaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.jdbc.DBConnect;
import tech.seekback.models.EstadosAgenda;
import tech.seekback.models.templates.TablesEnum;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class EstadosAgendaDAOMySQL implements EstadosAgendaDAO {

  private static final String TABLE = TablesEnum.ESTADOS_AGENDA.getNombreTabla();

  @Override
  public void create() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public EstadosAgenda getOne(Integer id) throws ConnectionExcep {
    try {
      PreparedStatement ps = DBConnect
              .getInstance()
              .prepareStatement(
                      "SELECT * FROM "
                      + TABLE
                      + " WHERE idEstado = ?"
              );
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      EstadosAgenda obj = null;
      Timestamps ts = null;

      if (rs.next()) {
        obj = new EstadosAgenda();
        obj.setIdEstado(rs.getInt("idEstado"));
        obj.setNombreEstado(rs.getString("nombreEstado"));

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
  public List<EstadosAgenda> getAll() throws ConnectionExcep {
    List<EstadosAgenda> list = new ArrayList<EstadosAgenda>();
    try {
      PreparedStatement ps = DBConnect
              .getInstance()
              .prepareStatement(
                      "SELECT * FROM "
                      + TABLE
              );
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        EstadosAgenda obj = new EstadosAgenda();
        obj.setIdEstado(rs.getInt("idEstado"));
        obj.setNombreEstado(rs.getString("nombreEstado"));

        Timestamps ts = new Timestamps();
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
  public void update(EstadosAgenda obj) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(Integer id) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
