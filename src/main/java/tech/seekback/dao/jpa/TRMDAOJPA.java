/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TRMDAO;
import tech.seekback.models.TRM;

/**
 *
 * @author camorenoc
 */
public class TRMDAOJPA extends GenericDAO<TRM, Integer> implements TRMDAO {

  public TRMDAOJPA() {
    super(TRM.class);
  }
}
