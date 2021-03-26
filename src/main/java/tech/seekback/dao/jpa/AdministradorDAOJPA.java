
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.AdministradorDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Administrador;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Date;

/**
 * @author gkentaurus
 */
@Stateless
public class AdministradorDAOJPA extends GenericDAO<Administrador, Integer> implements AdministradorDAO {

  public AdministradorDAOJPA() {
    super(Administrador.class);
  }

  /**
   * @param id del Usuario
   * @return Un objeto de tipo Administrador
   * @throws ConnectionExcep
   */
  @Override
  public Administrador getByIdUsuario(Integer id) throws ConnectionExcep {

    try {
      TypedQuery<Administrador> tq = em.createNamedQuery("Empleado.getByIdUsuario", classType);
      tq.setParameter("idUsuario", id);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  /**
   * Elimina un objeto de tipo Administrador
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(Administrador obj) throws ConnectionExcep {
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
