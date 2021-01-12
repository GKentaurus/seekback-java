/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import tech.seekback.dao.interfaces.OrdenCompraDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.OrdenCompra;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author camorenoc
 */
@Stateless
public class OrdenCompraService {

  @EJB
  private OrdenCompraDAO ordenCompraDAO;

  /**
   * @param ordenCompra
   * @return Un objeto de tipo de tipo OrdenCompra
   * @throws ConnectionExcep
   */
  public OrdenCompra create(OrdenCompra ordenCompra) throws ConnectionExcep {
    return ordenCompraDAO.create(ordenCompra);
  }

  /**
   * @param id
   * @return Un objeto de tipo OrdenCompra consultado por el id
   * @throws ConnectionExcep
   */
  public OrdenCompra getOne(Integer id) throws ConnectionExcep {
    return ordenCompraDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo OrdenCompra (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<OrdenCompra> getAll() throws ConnectionExcep {
    List<OrdenCompra> ordenesCompra = ordenCompraDAO.getAll();
    return ordenesCompra;
  }

  /**
   * Actualiza un objeto de tipo OrdenCompra
   *
   * @param pqrs
   * @throws ConnectionExcep
   */
  public void update(OrdenCompra pqrs) throws ConnectionExcep {
    ordenCompraDAO.update(pqrs);
  }

  /**
   * Elimina un objeto de tipo OrdenCompra
   *
   * @param ordenCompra
   * @throws ConnectionExcep
   */
  public void delete(OrdenCompra ordenCompra) throws ConnectionExcep {
    ordenCompraDAO.delete(ordenCompra);
  }
}