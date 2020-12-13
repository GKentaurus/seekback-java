/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.EmpleadoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Empleado;

/**
 *
 * @author camorenoc
 */
@Stateless
public class EmpleadoDAOJPA extends GenericDAO<Empleado, Integer> implements EmpleadoDAO {

  public EmpleadoDAOJPA() {
    super(Empleado.class);
  }

  /**
   *
   * @param id del Usuario
   * @return Un objeto de tipo Cliente
   * @throws ConnectionExcep
   */
  @Override
  public Empleado getByIdUsuario(Integer id) throws ConnectionExcep {

    try {
      TypedQuery<Empleado> tq = em.createNamedQuery("Empleado.getByIdUsuario", classType);
      tq.setParameter("idUsuario", id);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
