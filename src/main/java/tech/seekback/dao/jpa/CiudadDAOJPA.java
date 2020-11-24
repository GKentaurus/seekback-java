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
import tech.seekback.dao.interfaces.CiudadDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Ciudad;

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
    try {
      TypedQuery<Ciudad> tq = em.createNamedQuery("Ciudad.getByIdDepartamento", classType);
      tq.setParameter("DepartamentoId", idDepartamento);
      return tq.getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
