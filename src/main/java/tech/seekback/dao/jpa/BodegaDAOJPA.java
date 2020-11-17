/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.BodegaDAO;
import tech.seekback.models.Bodega;

/**
 *
 * @author camorenoc
 */
public class BodegaDAOJPA extends GenericDAO<Bodega, Integer> implements BodegaDAO {

  public BodegaDAOJPA() {
    super(Bodega.class);
  }
}
