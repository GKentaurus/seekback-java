package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Producto;

import javax.ejb.Local;
import java.util.List;

/**
 * @author gkentaurus
 */
@Local
public interface ProductoDAO extends DAO<Producto, Integer> {

  Integer getCatCount(Integer id) throws ConnectionExcep;

  List<Producto> getCategoryProducts(Integer idCategory) throws ConnectionExcep;

  List<Producto> getLastProducts(Integer limit) throws ConnectionExcep;
}
