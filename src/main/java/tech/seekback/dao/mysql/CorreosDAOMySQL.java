/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.mysql;

import java.util.List;
import tech.seekback.dao.CorreosDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correos;

/**
 *
 * @author camorenoc
 */
public class CorreosDAOMySQL implements CorreosDAO {

  @Override
  public void create() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Correos getOne(Integer id) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Correos> getAll() throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(Correos obj) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(Integer id) throws ConnectionExcep {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
