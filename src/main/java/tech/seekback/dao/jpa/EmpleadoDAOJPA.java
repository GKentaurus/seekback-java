/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.EmpleadoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Empleado;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Date;

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

  /**
   * Elimina un objeto de tipo Empleado
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(Empleado obj) throws ConnectionExcep {
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
