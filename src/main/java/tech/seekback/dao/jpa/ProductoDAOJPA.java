package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ProductoDAO;
import tech.seekback.models.Producto;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;

/**
 * @author gkentaurus
 */
@Stateless
public class ProductoDAOJPA extends GenericDAO<Producto, Integer> implements ProductoDAO {

  public ProductoDAOJPA() {
    super(Producto.class);
  }

  @Override
  public Integer getCatCount(Integer id) {
    TypedQuery<Producto> tq = em.createNamedQuery("Producto.getCatCount", classType);
    return ((Number) em.createNamedQuery("Producto.getCatCount")
            .setParameter("idCategoria", id)
            .getSingleResult())
            .intValue();
  }

  @Override
  public List<Producto> getCategoryProducts(Integer idCategory) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("Producto.getCategoryProducts", classType)
              .setParameter("idCategoria", idCategory)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public List<Producto> getLikeName(String parteNombre) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("Producto.getLikeName", classType)
              .setParameter("parteNombre", parteNombre)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public List<Producto> getLastProducts(Integer limit) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("Producto.getLastProducts", classType)
              .setMaxResults(4)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
