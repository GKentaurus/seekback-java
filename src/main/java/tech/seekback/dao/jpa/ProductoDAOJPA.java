package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ProductoDAO;
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
  public Integer getCatCount(Integer id) {
    TypedQuery<Producto> tq = em.createNamedQuery("Producto.getCatCount", classType);
    return ((Number)em.createNamedQuery("Producto.getCatCount")
      .setParameter("idCategoria", id)
      .getSingleResult())
      .intValue();
  }

  @Override
  public List<Producto> getCategoryProducts(Integer idCategory) {
    TypedQuery<Producto> tq = em.createNamedQuery("Producto.getCategoryProducts", classType);
    tq.setParameter("idCategoria", idCategory);
    return tq.getResultList();
  }

  @Override
  public List<Producto> getLastProducts(Integer limit) {
    TypedQuery<Producto> tq = em.createNamedQuery("Producto.getLastProducts", classType)
      .setMaxResults(4);
    return tq.getResultList();
  }
}
