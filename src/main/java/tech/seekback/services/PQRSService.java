/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.PQRSDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.PQRS;

/**
 *
 * @author camorenoc
 */
@Stateless
public class PQRSService {

  @EJB
  private PQRSDAO pqrsDAO;

  public PQRS create(PQRS pqrs) throws ConnectionExcep {
    return pqrsDAO.create(pqrs);
  }

  public PQRS getOne(Integer id) throws ConnectionExcep {
    return pqrsDAO.getOne(id);
  }

  public List<PQRS> getAll() throws ConnectionExcep {
    List<PQRS> usuarios = pqrsDAO.getAll();
    return usuarios;
  }

  public void update(PQRS pqrs) throws ConnectionExcep {
    pqrsDAO.update(pqrs);
  }

  public void delete(Integer id) throws ConnectionExcep {
    pqrsDAO.delete(id);
  }
}
