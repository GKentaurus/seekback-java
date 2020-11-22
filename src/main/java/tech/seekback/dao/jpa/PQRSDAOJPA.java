/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.PQRSDAO;
import tech.seekback.models.PQRS;

/**
 *
 * @author camorenoc
 */
@Stateless
public class PQRSDAOJPA extends GenericDAO<PQRS, Integer> implements PQRSDAO {

  public PQRSDAOJPA() {
    super(PQRS.class);
  }
}
