/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.models.Rol;
import tech.seekback.dao.interfaces.RolDAO;

/**
 *
 * @author camorenoc
 */
@Stateless
public class RolDAOJPA extends GenericDAO<Rol, Integer> implements RolDAO {

  public RolDAOJPA() {
    super(Rol.class);
  }
}
