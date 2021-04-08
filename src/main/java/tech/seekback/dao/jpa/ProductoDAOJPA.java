package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ProductoDAO;
import tech.seekback.models.Producto;

import javax.ejb.Stateless;
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
  public Integer getCatCount1() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("Producto.getCatCount1").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public Integer getCatCount2() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("Producto.getCatCount2").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public Integer getCatCount3() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("Producto.getCatCount3").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public Integer getCatCount4() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("Producto.getCatCount4").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public Integer getCatCount5() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("Producto.getCatCount5").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public Integer getCatCount6() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("Producto.getCatCount6").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
