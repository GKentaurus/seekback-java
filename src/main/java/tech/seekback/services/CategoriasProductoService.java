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

  /**
   *
   * @param categoriasProducto
   * @return Un objeto de tipo CategoriasProducto
   * @throws ConnectionExcep
   */
  public CategoriasProducto create(CategoriasProducto categoriasProducto) throws ConnectionExcep {
    return categoriasProductoDAO.create(categoriasProducto);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo CategoriasProducto consultado por el id
   * @throws ConnectionExcep
   */
  public CategoriasProducto getOne(Integer id) throws ConnectionExcep {
    return categoriasProductoDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo CategoriasProducto (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<CategoriasProducto> getAll() throws ConnectionExcep {
    return categoriasProductoDAO.getAll();
  }

  /**
   * Actualiza un objeto de tipo CategoriasProducto
   *
   * @param categoriasProducto
   * @throws ConnectionExcep
   */
  public void update(CategoriasProducto categoriasProducto) throws ConnectionExcep {
    categoriasProductoDAO.update(categoriasProducto);
  }

  /**
   * Elimina un objeto de tipo CategoriasProducto
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    categoriasProductoDAO.delete(id);
  }
}
