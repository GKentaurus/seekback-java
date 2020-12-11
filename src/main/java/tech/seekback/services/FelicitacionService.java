/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.FelicitacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Felicitacion;

/**
 *
 * @author camorenoc
 */
@Stateless
public class FelicitacionService {

  @EJB

  private FelicitacionDAO felicitacionDAO;

  public Felicitacion create(Felicitacion felicitacion) throws ConnectionExcep {
    return felicitacionDAO.create(felicitacion);
  }

  public Felicitacion getOne(Integer id) throws ConnectionExcep {
    return felicitacionDAO.getOne(id);
  }

  public List<Felicitacion> getAll() throws ConnectionExcep {
    return felicitacionDAO.getAll();
  }

  public void update(Felicitacion felicitacion) throws ConnectionExcep {
    felicitacionDAO.update(felicitacion);
  }

  public void delete(Integer id) throws ConnectionExcep {
    felicitacionDAO.delete(id);
  }
}
