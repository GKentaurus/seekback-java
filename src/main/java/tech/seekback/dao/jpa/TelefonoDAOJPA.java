/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TelefonoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Telefono;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Date;

/**
 *
 * @author camorenoc
 */
@Stateless
public class TelefonoDAOJPA extends GenericDAO<Telefono, Integer> implements TelefonoDAO {

  public TelefonoDAOJPA() {
    super(Telefono.class);
  }

  /**
   *
   * @param IdUsuario
   * @return Un objeto de tipo Telefono consultado por idUsuario
   * @throws ConnectionExcep
   */
  @Override
  public Telefono getByIdUsuario(Integer IdUsuario) throws ConnectionExcep {

    try {
      TypedQuery<Telefono> tq = em.createNamedQuery("Telefono.getByIdUsuario", classType);
      tq.setParameter("idUsuario", IdUsuario);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }

  }

  /**
   *
   * @param IdUsuario
   * @return Un objeto de tipo Telefono consultado por idUsuario
   * @throws ConnectionExcep
   */
  @Override
  public Telefono getByIdPrincipal(Integer IdUsuario) throws ConnectionExcep {

    try {
      TypedQuery<Telefono> tq = em.createNamedQuery("Telefono.getByIdPrincipal", classType);
      tq.setParameter("idUsuario", IdUsuario);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }

  }

  /**
   * Elimina un objeto de tipo Telefono
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(Telefono obj) throws ConnectionExcep {
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
