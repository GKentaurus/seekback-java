/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.BodegaProductosDAO;
import tech.seekback.models.BodegaProductos;

/**
 *
 * @author camorenoc
 */
public class BodegaProductosDAOJPA extends GenericDAO<BodegaProductos, Integer> implements BodegaProductosDAO {

  public BodegaProductosDAOJPA() {
    super(BodegaProductos.class);
  }
}
