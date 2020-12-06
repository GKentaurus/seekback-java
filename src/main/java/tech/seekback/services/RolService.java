/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Rol;
import tech.seekback.dao.interfaces.RolDAO;

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
}
