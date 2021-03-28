
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TelefonoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Telefono;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * @author gkentaurus
 */
@Stateless
public class TelefonoDAOJPA extends GenericDAO<Telefono, Integer> implements TelefonoDAO {

  public TelefonoDAOJPA() {
    super(Telefono.class);
  }

  /**
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
}
