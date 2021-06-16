package tech.seekback.services;

import tech.seekback.dao.interfaces.BodegaProductoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.BodegaProducto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class BodegaProductoService {

  @EJB

  private BodegaProductoDAO bodegaProductoDAO;

  /**
   * @param bodegaProducto
   * @return Un objeto de tipo BodegaProducto
   * @throws ConnectionExcep
   */
  public BodegaProducto create(BodegaProducto bodegaProducto) throws ConnectionExcep {
    return bodegaProductoDAO.create(bodegaProducto);
  }

  /**
   * @param id
   * @return Un objeto de tipo BodegaProducto consultado por el id
   * @throws ConnectionExcep
   */
  public BodegaProducto getOne(Integer id) throws ConnectionExcep {
    return bodegaProductoDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo BodegaProducto (referente al DAO
   * que lo implemente)
   * @throws ConnectionExcep
   */
  public List<BodegaProducto> getAll() throws ConnectionExcep {
    return bodegaProductoDAO.getAll();
  }

  /**
   * @param idProducto
   * @return Una colección de objetos de tipo producto consultado por idProducto
   * @throws ConnectionExcep
   */
  public List<BodegaProducto> getByIdCategoria(int idProducto) throws ConnectionExcep {
    List<BodegaProducto> bodegaProductos = bodegaProductoDAO.getByIdCategoria(idProducto);
    return bodegaProductos;
  }

  public BodegaProducto getByIdProducto(Integer idProducto) throws ConnectionExcep {
    BodegaProducto bodegaProductobyidproducto = bodegaProductoDAO.getByIdProducto(idProducto);
    return bodegaProductobyidproducto;
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
   * @param bodegaProducto
   * @throws ConnectionExcep
   */
  public void delete(BodegaProducto bodegaProducto) throws ConnectionExcep {
    bodegaProductoDAO.delete(bodegaProducto);
  }
}
