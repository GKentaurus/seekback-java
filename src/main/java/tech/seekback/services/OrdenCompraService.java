/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.OrdenCompraDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.OrdenCompra;

/**
 *
 * @author camorenoc
 */
@Stateless
public class OrdenCompraService {

  @EJB
  private OrdenCompraDAO ordenCompraDAO;

  public OrdenCompra create(OrdenCompra ordenCompra) throws ConnectionExcep {
    return ordenCompraDAO.create(ordenCompra);
  }

  public OrdenCompra getOne(Integer id) throws ConnectionExcep {
    return ordenCompraDAO.getOne(id);
  }

  public List<OrdenCompra> getAll() throws ConnectionExcep {
    List<OrdenCompra> ordenesCompra = ordenCompraDAO.getAll();
    return ordenesCompra;
  }

  public void update(OrdenCompra pqrs) throws ConnectionExcep {
    ordenCompraDAO.update(pqrs);
  }

  public void delete(Integer id) throws ConnectionExcep {
    ordenCompraDAO.delete(id);
  }
}
