package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.models.Producto;

import javax.ejb.Local;
import tech.seekback.exceptions.ConnectionExcep;

/**
 * @author gkentaurus
 */
@Local
public interface ProductoDAO extends DAO<Producto, Integer> {

  Integer getCatCount1() throws ConnectionExcep;

  Integer getCatCount2() throws ConnectionExcep;

  Integer getCatCount3() throws ConnectionExcep;

  Integer getCatCount4() throws ConnectionExcep;

  Integer getCatCount5() throws ConnectionExcep;

  Integer getCatCount6() throws ConnectionExcep;
  //
}
