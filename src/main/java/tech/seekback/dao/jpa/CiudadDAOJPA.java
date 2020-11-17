/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CiudadDAO;
import tech.seekback.models.Ciudad;

/**
 *
 * @author camorenoc
 */
public class CiudadDAOJPA extends GenericDAO<Ciudad, Integer> implements CiudadDAO {

  public CiudadDAOJPA() {
    super(Ciudad.class);
  }
}
