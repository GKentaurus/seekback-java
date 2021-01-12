/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CiudadDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Ciudad;
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
public class CiudadDAOJPA extends GenericDAO<Ciudad, Integer> implements CiudadDAO {

  public CiudadDAOJPA() {
    super(Ciudad.class);
  }

  @Override
  public List<Ciudad> getByIdDepartamento(Integer idDepartamento) throws ConnectionExcep {
    System.out.println("id ---- " + idDepartamento);
    try {
      TypedQuery<Ciudad> tq = em.createNamedQuery("Ciudad.getByIdDepartamento", classType);
      tq.setParameter("DepartamentoId", idDepartamento);
      return tq.getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  /**
   * Elimina un objeto de tipo Ciudad
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(Ciudad obj) throws ConnectionExcep {
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
