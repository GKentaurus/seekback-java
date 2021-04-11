package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.BodegaProductoDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.BodegaProducto;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class BodegaProductoDAOJPA extends GenericDAO<BodegaProducto, Integer> implements BodegaProductoDAO {

  public BodegaProductoDAOJPA() {
    super(BodegaProducto.class);
  }

  /**
   * @param idCategoria
   * @return Un objeto de tipo BodegaProducto consultado por idCategoria
   * @throws ConnectionExcep
   */
  @Override
  public List<BodegaProducto> getByIdCategoria(int idCategoria) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("BodegaProducto.getByIdCategoria", classType)
              .setParameter("idCategoria", idCategoria)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public List<BodegaProducto> getLikeName(String parteNombre) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("BodegaProducto.getLikeName", classType)
              .setParameter("parteNombre", parteNombre)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public BodegaProducto getByIdProducto(Integer idProducto) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("BodegaProducto.getByIdProducto", classType)
              .setParameter("idProducto", idProducto)
              .getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
