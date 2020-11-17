/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.RolesDAO;
import tech.seekback.models.Roles;

/**
 *
 * @author camorenoc
 */
public class RolesDAOJPA extends GenericDAO<Roles, Integer> implements RolesDAO {

  public RolesDAOJPA() {
    super(Roles.class);
  }
}
