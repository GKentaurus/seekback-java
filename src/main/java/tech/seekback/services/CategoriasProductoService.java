/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.CategoriasProductoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.CategoriasProducto;

/**
 *
 * @author camorenoc
 */
@Stateless
public class CategoriasProductoService {

  @EJB

  private CategoriasProductoDAO categoriasProductoDAO;

  public CategoriasProducto create(CategoriasProducto categoriasProducto) throws ConnectionExcep {
    return categoriasProductoDAO.create(categoriasProducto);
  }

  public CategoriasProducto getOne(Integer id) throws ConnectionExcep {
    return categoriasProductoDAO.getOne(id);
  }

  public List<CategoriasProducto> getAll() throws ConnectionExcep {
    return categoriasProductoDAO.getAll();
  }

  public void update(CategoriasProducto categoriasProducto) throws ConnectionExcep {
    categoriasProductoDAO.update(categoriasProducto);
  }

  public void delete(Integer id) throws ConnectionExcep {
    categoriasProductoDAO.delete(id);
  }
}
