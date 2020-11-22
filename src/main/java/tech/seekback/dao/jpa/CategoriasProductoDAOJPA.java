/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CategoriasProductoDAO;
import tech.seekback.models.CategoriasProducto;

/**
 *
 * @author camorenoc
 */
@Stateless
public class CategoriasProductoDAOJPA extends GenericDAO<CategoriasProducto, Integer> implements CategoriasProductoDAO {

  public CategoriasProductoDAOJPA() {
    super(CategoriasProducto.class);
  }
}