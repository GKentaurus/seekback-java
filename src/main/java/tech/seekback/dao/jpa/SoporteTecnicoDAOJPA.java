
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.SoporteTecnicoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.SoporteTecnico;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import java.util.Date;

/**
 * @author gkentaurus
 */
@Stateless
public class SoporteTecnicoDAOJPA extends GenericDAO<SoporteTecnico, Integer> implements SoporteTecnicoDAO {

  public SoporteTecnicoDAOJPA() {
    super(SoporteTecnico.class);
  }

  /**
   * @return Un entero de la consulta COUNT de SoporteTecnico
   * @throws ConnectionExcep
   */
  @Override
  public Integer getAllCount() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("SoporteTecnico.getAllCount").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }

  }

  /**
   * Elimina un objeto de tipo SoporteTecnico
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(SoporteTecnico obj) throws ConnectionExcep {
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
