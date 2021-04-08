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
    List<Producto> productos = productoDAO.getAll();
    return productos;
  }

  public Integer getCatCount1() throws ConnectionExcep {
    Integer CatCount1 = productoDAO.getCatCount1();
    return CatCount1;
  }

  public Integer getCatCount2() throws ConnectionExcep {
    Integer CatCount1 = productoDAO.getCatCount2();
    return CatCount1;
  }

  public Integer getCatCount3() throws ConnectionExcep {
    Integer CatCount1 = productoDAO.getCatCount3();
    return CatCount1;
  }

  public Integer getCatCount4() throws ConnectionExcep {
    Integer CatCount1 = productoDAO.getCatCount4();
    return CatCount1;
  }

  public Integer getCatCount5() throws ConnectionExcep {
    Integer CatCount1 = productoDAO.getCatCount5();
    return CatCount1;
  }

  public Integer getCatCount6() throws ConnectionExcep {
    Integer CatCount1 = productoDAO.getCatCount6();
    return CatCount1;
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
