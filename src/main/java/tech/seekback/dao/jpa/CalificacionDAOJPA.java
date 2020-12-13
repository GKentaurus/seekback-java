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
import tech.seekback.dao.interfaces.CalificacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Calificacion;
import tech.seekback.models.Departamento;

/**
 *
 * @author camorenoc
 */
@Stateless
public class CalificacionDAOJPA extends GenericDAO<Calificacion, Integer> implements CalificacionDAO {

  public CalificacionDAOJPA() {
    super(Calificacion.class);
  }

  /**
   *
   * @param idProducto
   * @return Un objeto de tipo Calificacion consultado por idProducto
   * @throws ConnectionExcep
   */
  @Override
  public List<Calificacion> getByIdProducto(int idProducto) throws ConnectionExcep {
    try {
      TypedQuery<Calificacion> tq = em.createNamedQuery("Calificacion.getByIdProducto", classType);
      tq.setParameter("idProducto", idProducto);
      return tq.getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
