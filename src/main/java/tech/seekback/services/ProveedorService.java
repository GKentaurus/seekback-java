/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.ProveedorDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Proveedor;

/**
 *
 * @author camorenoc
 */
@Stateless
public class ProveedorService {

  @EJB
  private ProveedorDAO proveedorDAO;

  public void create(Proveedor proveedor) throws ConnectionExcep {
    proveedorDAO.create(proveedor);
  }

  public Proveedor getOne(Integer id) throws ConnectionExcep {
    return proveedorDAO.getOne(id);
  }

  public List<Proveedor> getAll() throws ConnectionExcep {
    List<Proveedor> proveedores = proveedorDAO.getAll();
    return proveedores;
  }

  public void update(Proveedor proveedor) throws ConnectionExcep {
    proveedorDAO.update(proveedor);
  }

  public void delete(Integer id) throws ConnectionExcep {
    proveedorDAO.delete(id);
  }
}
