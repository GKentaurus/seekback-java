/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.DivisasDAO;
import tech.seekback.models.Divisas;

/**
 *
 * @author camorenoc
 */
@Stateless
public class DivisasDAOJPA extends GenericDAO<Divisas, Integer> implements DivisasDAO {

  public DivisasDAOJPA() {
    super(Divisas.class);
  }
}
