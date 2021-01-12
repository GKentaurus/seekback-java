/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import tech.seekback.dao.interfaces.ProductoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Producto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author camorenoc
 */
@Stateless
public class ProductoService {

  @EJB
  private ProductoDAO productoDAO;

  /**
   * @param producto
   * @return Un objeto de tipo de tipo Producto
   * @throws ConnectionExcep
   */
  public Producto create(Producto producto) throws ConnectionExcep {
    return productoDAO.create(producto);
  }

  /**
   * @param id
   * @return Un objeto de tipo de tipo Producto consultado por id
   * @throws ConnectionExcep
   */
  public Producto getOne(Integer id) throws ConnectionExcep {
    return productoDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Producto (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Producto> getAll() throws ConnectionExcep {
    List<Producto> productos = productoDAO.getAll();
    return productos;
  }

  /**
   * Actualiza un objeto de tipo Producto
   *
   * @param producto
   * @throws ConnectionExcep
   */
  public void update(Producto producto) throws ConnectionExcep {
    productoDAO.update(producto);
  }

  /**
   * Elimina un objeto de tipo Producto
   *
   * @param producto
   * @throws ConnectionExcep
   */
  public void delete(Producto producto) throws ConnectionExcep {
    productoDAO.delete(producto);
  }
}