/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.BodegaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Bodega;

/**
 *
 * @author camorenoc
 */
@Stateless
public class BodegaService {

  @EJB

  private BodegaDAO bodegaDAO;

  public Bodega create(Bodega bodega) throws ConnectionExcep {
    return bodegaDAO.create(bodega);
  }

  public Bodega getOne(Integer id) throws ConnectionExcep {
    return bodegaDAO.getOne(id);
  }

  public List<Bodega> getAll() throws ConnectionExcep {
    return bodegaDAO.getAll();
  }

  public void update(Bodega bodega) throws ConnectionExcep {
    bodegaDAO.update(bodega);
  }

  public void delete(Integer id) throws ConnectionExcep {
    bodegaDAO.delete(id);
  }
}
