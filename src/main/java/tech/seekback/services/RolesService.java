/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import tech.seekback.dao.interfaces.RolesDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Roles;

/**
 *
 * @author camorenoc
 */
public class RolesService {

  @EJB
  private RolesDAO rolesDAO;

  public void create(Roles rol) throws ConnectionExcep {
    rolesDAO.create(rol);
  }

  public List<Roles> getAll() throws ConnectionExcep {
    List<Roles> roles = rolesDAO.getAll();
    return roles;
  }
}
