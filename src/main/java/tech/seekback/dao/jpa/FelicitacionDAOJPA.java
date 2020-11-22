/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.FelicitacionDAO;
import tech.seekback.models.Felicitacion;

/**
 *
 * @author camorenoc
 */
@Stateless
public class FelicitacionDAOJPA extends GenericDAO<Felicitacion, Integer> implements FelicitacionDAO {

  public FelicitacionDAOJPA() {
    super(Felicitacion.class);
  }
}
