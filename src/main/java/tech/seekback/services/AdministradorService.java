/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.AdministradorDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Administrador;

/**
 *
 * @author camorenoc
 */
@Stateless
public class AdministradorService {

  @EJB

  private AdministradorDAO administradorDAO;

  public Administrador create(Administrador administrador) throws ConnectionExcep {
    return administradorDAO.create(administrador);
  }

  public Administrador getOne(Integer id) throws ConnectionExcep {
    return administradorDAO.getOne(id);
  }

  public List<Administrador> getAll() throws ConnectionExcep {
    return administradorDAO.getAll();
  }

  public void update(Administrador administrador) throws ConnectionExcep {
    administradorDAO.update(administrador);
  }

  public void delete(Integer id) throws ConnectionExcep {
    administradorDAO.delete(id);
  }
}
