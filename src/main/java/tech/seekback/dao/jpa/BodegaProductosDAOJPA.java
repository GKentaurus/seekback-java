/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.BodegaProductosDAO;
import tech.seekback.models.BodegaProductos;

/**
 *
 * @author camorenoc
 */
@Stateless
public class BodegaProductosDAOJPA extends GenericDAO<BodegaProductos, Integer> implements BodegaProductosDAO {

  public BodegaProductosDAOJPA() {
    super(BodegaProductos.class);
  }
}
