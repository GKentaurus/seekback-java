/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CorreosDAO;
import tech.seekback.models.Correos;

/**
 *
 * @author camorenoc
 */
@Stateless
public class CorreosDAOJPA extends GenericDAO<Correos, Integer> implements CorreosDAO {

  public CorreosDAOJPA() {
    super(Correos.class);
  }
}
