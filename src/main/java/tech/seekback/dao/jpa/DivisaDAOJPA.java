/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.models.Divisa;
import tech.seekback.dao.interfaces.DivisaDAO;

/**
 *
 * @author camorenoc
 */
@Stateless
public class DivisaDAOJPA extends GenericDAO<Divisa, Integer> implements DivisaDAO {

  public DivisaDAOJPA() {
    super(Divisa.class);
  }
}
