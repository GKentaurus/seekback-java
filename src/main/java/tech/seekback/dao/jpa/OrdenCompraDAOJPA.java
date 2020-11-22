/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.OrdenCompraDAO;
import tech.seekback.models.OrdenCompra;

/**
 *
 * @author camorenoc
 */
@Stateless
public class OrdenCompraDAOJPA extends GenericDAO<OrdenCompra, Integer> implements OrdenCompraDAO {

  public OrdenCompraDAOJPA() {
    super(OrdenCompra.class);
  }
}
