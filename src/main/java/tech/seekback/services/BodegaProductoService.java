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

  /**
   *
   * @param bodegaProducto
   * @return Un objeto de tipo BodegaProducto
   * @throws ConnectionExcep
   */
  public BodegaProducto create(BodegaProducto bodegaProducto) throws ConnectionExcep {
    return bodegaProductoDAO.create(bodegaProducto);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo BodegaProducto consultado por el id
   * @throws ConnectionExcep
   */
  public BodegaProducto getOne(Integer id) throws ConnectionExcep {
    return bodegaProductoDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo BodegaProducto (referente al DAO
   * que lo implemente)
   * @throws ConnectionExcep
   */
  public List<BodegaProducto> getAll() throws ConnectionExcep {
    return bodegaProductoDAO.getAll();
  }

  /**
   *
   * @param idProducto
   * @return Una colección de objetos de tipo Calificacion consultado por
   * idProducto
   * @throws ConnectionExcep
   */
  public List<BodegaProducto> getByIdCategoria(int idProducto) throws ConnectionExcep {
    List<BodegaProducto> bodegaProductos = bodegaProductoDAO.getByIdCategoria(idProducto);
    return bodegaProductos;
  }

  /**
   * Actualiza un objeto tipo BodegaProducto
   *
   * @param bodegaProducto
   * @throws ConnectionExcep
   */
  public void update(BodegaProducto bodegaProducto) throws ConnectionExcep {
    bodegaProductoDAO.update(bodegaProducto);
  }

  /**
   * Elimina un objeto tipo BodegaProducto
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    bodegaProductoDAO.delete(id);
  }
}
