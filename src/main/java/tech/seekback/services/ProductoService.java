/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.ProductoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Producto;

/**
 *
 * @author camorenoc
 */
@Stateless
public class ProductoService {

  @EJB
  private ProductoDAO productoDAO;

  public Producto create(Producto producto) throws ConnectionExcep {
    return productoDAO.create(producto);
  }

  public Producto getOne(Integer id) throws ConnectionExcep {
    return productoDAO.getOne(id);
  }

  public List<Producto> getAll() throws ConnectionExcep {
    List<Producto> productos = productoDAO.getAll();
    return productos;
  }

  public void update(Producto producto) throws ConnectionExcep {
    productoDAO.update(producto);
  }

  public void delete(Integer id) throws ConnectionExcep {
    productoDAO.delete(id);
  }
}
