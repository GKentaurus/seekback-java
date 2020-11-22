/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TelefonosDAO;
import tech.seekback.models.Telefonos;

/**
 *
 * @author camorenoc
 */
@Stateless
public class TelefonosDAOJPA extends GenericDAO<Telefonos, Integer> implements TelefonosDAO {

  public TelefonosDAOJPA() {
    super(Telefonos.class);
  }
}
