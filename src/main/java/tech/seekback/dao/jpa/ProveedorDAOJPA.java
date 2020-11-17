/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ProveedorDAO;
import tech.seekback.models.Proveedor;

/**
 *
 * @author camorenoc
 */
public class ProveedorDAOJPA extends GenericDAO<Proveedor, Integer> implements ProveedorDAO {

  public ProveedorDAOJPA() {
    super(Proveedor.class);
  }
}
