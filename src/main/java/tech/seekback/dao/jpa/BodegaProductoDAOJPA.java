/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.BodegaProductoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.BodegaProducto;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

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

  /**
   * Elimina un objeto de tipo BodegaProducto
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(BodegaProducto obj) throws ConnectionExcep {
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Eliminando el objeto No. " + this.classType.getSimpleName()
        + "\n######################################################################\n"
    );
    Timestamps tt = obj.getTimestamps();
    tt.setDeleted(true);
    tt.setDeleted_at(new Date());
    obj.setTimestamps(tt);
    create(obj);
  }
}
