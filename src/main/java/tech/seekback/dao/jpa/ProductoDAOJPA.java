package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ProductoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Producto;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class ProductoDAOJPA extends GenericDAO<Producto, Integer> implements ProductoDAO {

  public ProductoDAOJPA() {
    super(Producto.class);
  }

  @Override
  public Integer getCatCount(Integer id) throws ConnectionExcep {
    TypedQuery<Producto> tq = em.createNamedQuery("Producto.getCatCount", classType);
    return ((Number)em.createNamedQuery("Producto.getCatCount")
      .setParameter("idCategoria", id)
      .getSingleResult())
      .intValue();
  }
  @Override
  public List<Producto> getCategoryProducts(Integer idCategory) throws ConnectionExcep {
    TypedQuery<Producto> tq = em.createNamedQuery("Producto.getCategoryProducts", classType);
    tq.setParameter("idCategoria", idCategory);
    return tq.getResultList();
  }
}
