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
import tech.seekback.dao.RolesDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.jdbc.DBConnect;
import tech.seekback.models.Roles;
import tech.seekback.models.templates.TablesEnum;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class RolesDAOMySQL implements RolesDAO {

  @Override
  public void create() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Roles getOne(Integer id) throws ConnectionExcep {
    try {
      PreparedStatement ps = DBConnect
              .getInstance()
              .prepareStatement(
                      "SELECT * FROM "
                      + TablesEnum.ROLES.getNombreTabla()
                      + " WHERE idRol = ?"
              );
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      Roles obj = null;
      Timestamps ts = null;

      if (rs.next()) {
        obj = new Roles();
        obj.setIdRol(rs.getInt("idRol"));
        obj.setNombreRol(rs.getString("nombreRol"));

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
  public List<Roles> getAll() throws ConnectionExcep {
    List<Roles> listaRoles = new ArrayList<Roles>();
    try {
      PreparedStatement ps = DBConnect
              .getInstance()
              .prepareStatement(
                      "SELECT * FROM "
                      + TablesEnum.ROLES.getNombreTabla()
              );
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        Roles obj = new Roles();
        Timestamps ts = new Timestamps();

        obj.setIdRol(rs.getInt("idRol"));
        obj.setNombreRol(rs.getString("nombreRol"));
        ts.setDateData(rs);
        obj.setTimestamps(ts);
        listaRoles.add(obj);
      }
      return listaRoles;
    } catch (SQLException ex) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONSULTA, ex);
    }
  }

  @Override
  public void update(Roles obj) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(Integer id) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
