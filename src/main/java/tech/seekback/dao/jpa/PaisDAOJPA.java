/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.PaisDAO;
import tech.seekback.models.Pais;

/**
 *
 * @author camorenoc
 */
public class PaisDAOJPA extends GenericDAO<Pais, Integer> implements PaisDAO {

  public PaisDAOJPA() {
    super(Pais.class);
  }
}
