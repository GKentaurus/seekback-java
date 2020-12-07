/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.DivisaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Divisa;

/**
 *
 * @author camorenoc
 */
@Stateless
public class DivisaService {

  @EJB

  private DivisaDAO divisaDAO;

  public void create(Divisa divisa) throws ConnectionExcep {
    divisaDAO.create(divisa);
  }

  public Divisa getOne(Integer id) throws ConnectionExcep {
    return divisaDAO.getOne(id);
  }

  public List<Divisa> getAll() throws ConnectionExcep {
    return divisaDAO.getAll();
  }

  public void update(Divisa divisa) throws ConnectionExcep {
    divisaDAO.update(divisa);
  }

  public void delete(Integer id) throws ConnectionExcep {
    divisaDAO.delete(id);
  }
}
