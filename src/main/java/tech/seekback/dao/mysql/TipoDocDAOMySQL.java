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
import tech.seekback.dao.TipoDocDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.jdbc.DBConnect;
import tech.seekback.models.TipoDoc;
import tech.seekback.models.templates.TablesEnum;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class TipoDocDAOMySQL implements TipoDocDAO {

  @Override
  public void create() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public TipoDoc getOne(Integer id) throws ConnectionExcep {
    try {
      PreparedStatement ps = DBConnect.getInstance().prepareStatement(
              "SELECT * FROM "
              + TablesEnum.TIPO_DOC.getNombreTabla()
              + " WHERE idTipoDoc = ?"
      );
      ps.setInt(1, id);

      ResultSet rs = ps.executeQuery();

      TipoDoc obj = null;
      Timestamps ts = null;

      if (rs.next()) {
        obj = new TipoDoc();

        obj.setIdTipoDoc(rs.getInt("idTipoDoc"));
        obj.setNombreDocumento(rs.getString("nombreDocumento"));
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
  public List<TipoDoc> getAll() throws ConnectionExcep {
    try {
      List<TipoDoc> listaTipoDoc = new ArrayList<TipoDoc>();

      PreparedStatement ps = DBConnect.getInstance().prepareStatement(
              "SELECT * FROM "
              + TablesEnum.TIPO_DOC.getNombreTabla()
      );

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {

        TipoDoc obj = null;
        Timestamps ts = null;

        obj = new TipoDoc();

        obj.setIdTipoDoc(rs.getInt("idTipoDoc"));
        obj.setNombreDocumento(rs.getString("nombreDocumento"));
        obj.setSigla(rs.getString("sigla"));

        ts = new Timestamps();

        ts.setCreated_at(rs.getDate("created_at"));
        ts.setUpdated_at(rs.getDate("updated_at"));
        ts.setDeleted_at(rs.getDate("deleted_at"));

        obj.setTimestamps(ts);

        listaTipoDoc.add(obj);

      }

      return listaTipoDoc;

    } catch (SQLException ex) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONSULTA, ex);
    }
  }

  @Override
  public void update(TipoDoc obj) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(Integer id) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}