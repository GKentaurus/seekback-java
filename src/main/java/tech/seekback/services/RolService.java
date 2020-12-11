/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tech.seekback.dao.interfaces.RolDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Rol;

/**
 *
 * @author camorenoc
 */
@Stateless
public class RolService {

  @EJB
  private RolDAO rolesDAO;

  public void create(Rol rol) throws ConnectionExcep {
    rolesDAO.create(rol);
  }

  public List<Rol> getAll() throws ConnectionExcep {
    List<Rol> roles = rolesDAO.getAll();
    return roles;
  }

  public Rol getOne(Integer id) throws ConnectionExcep {
    return rolesDAO.getOne(id);
  }

  public void update(Rol rol) throws ConnectionExcep {
    rolesDAO.update(rol);
  }

  public void delete(Integer id) throws ConnectionExcep {
    rolesDAO.delete(id);
  }
}
