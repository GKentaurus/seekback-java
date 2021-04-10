package tech.seekback.dao.jpa;

import java.util.List;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TRMDAO;
import tech.seekback.models.TRM;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;

/**
 * @author gkentaurus
 */
@Stateless
public class TRMDAOJPA extends GenericDAO<TRM, Integer> implements TRMDAO {

  public TRMDAOJPA() {
    super(TRM.class);
  }

  @Override
  public List<TRM> getByidDivisa(Integer idDivisa) throws ConnectionExcep {
    System.out.println("divisa " + idDivisa);
    try {
      return em
              .createNamedQuery("TRM.getByidDivisa", classType)
              .setParameter("idDivisa", idDivisa)
              .setMaxResults(1)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
