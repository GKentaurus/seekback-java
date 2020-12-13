/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import tech.seekback.dao.GenericDAO;
import tech.seekback.models.BodegaProducto;
import tech.seekback.dao.interfaces.BodegaProductoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;

/**
 *
 * @author camorenoc
 */
@Stateless
public class BodegaProductoDAOJPA extends GenericDAO<BodegaProducto, Integer> implements BodegaProductoDAO {

  public BodegaProductoDAOJPA() {
    super(BodegaProducto.class);
  }

  /**
   *
   * @param idCategoria
   * @return Un objeto de tipo BodegaProducto consultado por idCategoria
   * @throws ConnectionExcep
   */
  @Override
  public List<BodegaProducto> getByIdCategoria(int idCategoria) throws ConnectionExcep {
    try {
      TypedQuery<BodegaProducto> tq = em.createNamedQuery("BodegaProducto.getByIdCategoria", classType);
      tq.setParameter("idCategoria", idCategoria);
      return tq.getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

}
