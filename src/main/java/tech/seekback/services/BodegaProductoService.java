/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.BodegaProductoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.BodegaProducto;

/**
 *
 * @author camorenoc
 */
@Stateless
public class BodegaProductoService {

  @EJB

  private BodegaProductoDAO bodegaProductoDAO;

  public BodegaProducto create(BodegaProducto bodegaProducto) throws ConnectionExcep {
    return bodegaProductoDAO.create(bodegaProducto);
  }

  public BodegaProducto getOne(Integer id) throws ConnectionExcep {
    return bodegaProductoDAO.getOne(id);
  }

  public List<BodegaProducto> getAll() throws ConnectionExcep {
    return bodegaProductoDAO.getAll();
  }

  public void update(BodegaProducto bodegaProducto) throws ConnectionExcep {
    bodegaProductoDAO.update(bodegaProducto);
  }

  public void delete(Integer id) throws ConnectionExcep {
    bodegaProductoDAO.delete(id);
  }
}
