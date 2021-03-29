
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.PQRSDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.PQRS;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class PQRSDAOJPA extends GenericDAO<PQRS, Integer> implements PQRSDAO {

  public PQRSDAOJPA() {
    super(PQRS.class);
  }

  /**
   * @return Un entero de la consulta COUNT de PQRS
   * @throws ConnectionExcep
   */
  @Override
  public Integer getAllCount() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("PQRS.getAllCount").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }

  }
}
