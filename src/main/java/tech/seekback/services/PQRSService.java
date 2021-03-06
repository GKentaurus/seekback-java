package tech.seekback.services;

import tech.seekback.dao.interfaces.PQRSDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.PQRS;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class PQRSService {

  @EJB
  private PQRSDAO pqrsDAO;

  /**
   * @param pqrs
   * @return Un objeto de tipo de tipo PQRS
   * @throws ConnectionExcep
   */
  public PQRS create(PQRS pqrs) throws ConnectionExcep {
    return pqrsDAO.create(pqrs);
  }

  /**
   * @param id
   * @return Un objeto de tipo de tipo PQRS consultdo por el id
   * @throws ConnectionExcep
   */
  public PQRS getOne(Integer id) throws ConnectionExcep {
    return pqrsDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo PQRS (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<PQRS> getAll() throws ConnectionExcep {
    List<PQRS> pqrs = pqrsDAO.getAll();
    return pqrs;
  }

  /**
   * @return Un entero de la consulta a PQRS (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public Integer getAllCount() throws ConnectionExcep {
    Integer countpqrs = pqrsDAO.getAllCount();
    return countpqrs;
  }

  public List<PQRS> getByidCliente(Integer idCliente) throws ConnectionExcep {
    List<PQRS> byidcliente = pqrsDAO.getByCliente(idCliente);
    return byidcliente;
  }

  /**
   * Actualiza un objeto de tipo PQRS
   *
   * @param pqrs
   * @throws ConnectionExcep
   */
  public void update(PQRS pqrs) throws ConnectionExcep {
    pqrsDAO.update(pqrs);
  }

  /**
   * Elimina un objeto de tipo PQRS
   *
   * @param pqrs
   * @throws ConnectionExcep
   */
  public void delete(PQRS pqrs) throws ConnectionExcep {
    pqrsDAO.delete(pqrs);
  }
}
