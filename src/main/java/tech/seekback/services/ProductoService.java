package tech.seekback.services;

import tech.seekback.dao.interfaces.ProductoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Producto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
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
   * @return Una colección de objetos de tipo Producto (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<Producto> getAll() throws ConnectionExcep {
    return productoDAO.getAll();
  }

  public Integer getCategoryCount(Integer id) throws ConnectionExcep {
    return productoDAO.getCatCount(id);
  }

  public List<Producto> getCategoryProducts(Integer idCategory) throws ConnectionExcep {
    return productoDAO.getCategoryProducts(idCategory);
  }

  public List<Producto> getLastProducts(Integer limit) throws ConnectionExcep {
    return productoDAO.getLastProducts(limit);
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
