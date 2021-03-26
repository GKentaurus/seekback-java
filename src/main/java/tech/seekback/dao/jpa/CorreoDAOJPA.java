
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CorreoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Correo;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Date;

/**
 * @author gkentaurus
 */
@Stateless
public class CorreoDAOJPA extends GenericDAO<Correo, Integer> implements CorreoDAO {

  public CorreoDAOJPA() {
    super(Correo.class);
  }

  /**
   * @param email
   * @return Un objeto tipo Correo consultado por el correo electronico
   * @throws ConnectionExcep
   */
  @Override
  public Correo getByCorreo(String email) throws ConnectionExcep {
    try {
      TypedQuery<Correo> tq = em.createNamedQuery("Correo.getByCorreo", classType);
      tq.setParameter("CorreoRec", email);
      try {
        Correo correo = tq.getSingleResult();
        return correo;
      } catch (NoResultException ex) {
        return null;
      }

    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }

  }

  /**
   * @param idUsuario
   * @return Un objeto tipo Correo consultado por el correo electronico
   * @throws ConnectionExcep
   */
  @Override
  public Correo getByIdPrincipal(Integer idUsuario) throws ConnectionExcep {
    try {
      TypedQuery<Correo> tq = em.createNamedQuery("Correo.getByIdPrincipal", classType);
      tq.setParameter("idUsuario", idUsuario);
      try {
        Correo correo = tq.getSingleResult();
        return correo;
      } catch (NoResultException ex) {
        return null;
      }

    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }

  }

  /**
   * Elimina un objeto de tipo Correo
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(Correo obj) throws ConnectionExcep {
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
