
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.DireccionDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Direccion;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * @author gkentaurus
 */
@Stateless
public class DireccionDAOJPA extends GenericDAO<Direccion, Integer> implements DireccionDAO {

  public DireccionDAOJPA() {
    super(Direccion.class);
  }

  /**
   * @param idUsuario
   * @return Un objeto tipo Correo consultado por el correo electronico
   * @throws ConnectionExcep
   */
  @Override
  public Direccion getByIdPrincipal(Integer idUsuario) throws ConnectionExcep {
    try {
      TypedQuery<Direccion> tq = em.createNamedQuery("Direccion.getByIdPrincipal", classType);
      tq.setParameter("idUsuario", idUsuario);
      try {
        Direccion direccion = tq.getSingleResult();
        return direccion;
      } catch (NoResultException ex) {
        return null;
      }

    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
