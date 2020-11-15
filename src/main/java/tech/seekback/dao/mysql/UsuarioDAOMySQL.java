/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import tech.seekback.dao.UsuarioDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.jdbc.DBConnect;
import tech.seekback.models.TipoDoc;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.TablesEnum;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class UsuarioDAOMySQL implements UsuarioDAO {

  @Override
  public void create() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Usuario getOne(Integer id) throws ConnectionExcep {
    try {
      PreparedStatement ps = DBConnect
              .getInstance()
              .prepareStatement(
                      "SELECT * FROM "
                      + TablesEnum.USUARIO.getNombreTabla()
                      + " WHERE idUsuario = ?"
              );
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      Usuario obj = null;
      TipoDoc doc = null;
      Timestamps ts = null;

      if (rs.next()) {
        obj = new Usuario();
        obj.setIdUsuario(rs.getInt("idUsuario"));
        obj.setpNombre(rs.getString("pNombre"));
        obj.setsNombres(rs.getString("sNombres"));
        obj.setpApellido(rs.getString("pApellido"));
        obj.setsApellido(rs.getString("sApellido"));
        // TODO: Integración de la clase TipoDoc
        obj.setNumeroDoc(rs.getString("numeroDoc"));
        // TODO: Integración de la clase Roles

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
  public List<Usuario> getAll() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(Usuario obj) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(Integer id) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
