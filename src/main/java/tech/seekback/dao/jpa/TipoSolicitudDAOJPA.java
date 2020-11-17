/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import java.util.List;
import tech.seekback.dao.TipoSolicitudDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoSolicitud;
import tech.seekback.models.templates.TablesEnum;

/**
 *
 * @author camorenoc
 */
public class TipoSolicitudDAOJPA implements TipoSolicitudDAO {

  private static final String TABLE = TablesEnum.TIPO_SOLICITUD.getNombreTabla();

  @Override
  public void create() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public TipoSolicitud getOne(Integer id) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<TipoSolicitud> getAll() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(TipoSolicitud obj) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(Integer id) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
