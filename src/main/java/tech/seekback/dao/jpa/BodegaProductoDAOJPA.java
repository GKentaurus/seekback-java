/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.models.BodegaProducto;
import tech.seekback.dao.interfaces.BodegaProductoDAO;

/**
 *
 * @author camorenoc
 */
@Stateless
public class BodegaProductoDAOJPA extends GenericDAO<BodegaProducto, Integer> implements BodegaProductoDAO {

  public BodegaProductoDAOJPA() {
    super(BodegaProducto.class);
  }
}
