
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.FelicitacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Felicitacion;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class FelicitacionDAOJPA extends GenericDAO<Felicitacion, Integer> implements FelicitacionDAO {

  public FelicitacionDAOJPA() {
    super(Felicitacion.class);
  }

  /**
   * @return Un entero de la consulta COUNT de Felicitacion
   * @throws ConnectionExcep
   */
  @Override
  public Integer getAllCount() throws ConnectionExcep {
    try {
      Integer cont = ((Number) em.createNamedQuery("Felicitacion.getAllCount").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
