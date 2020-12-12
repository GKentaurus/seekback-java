/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.PQRSDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.PQRS;

/**
 *
 * @author camorenoc
 */
@Stateless
public class PQRSService {

  @EJB
  private PQRSDAO pqrsDAO;

  /**
   *
   *
   * @param pqrs
   * @return Un objeto de tipo de tipo PQRS
   * @throws ConnectionExcep
   */
  public PQRS create(PQRS pqrs) throws ConnectionExcep {
    return pqrsDAO.create(pqrs);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo de tipo PQRS consultdo por el id
   * @throws ConnectionExcep
   */
  public PQRS getOne(Integer id) throws ConnectionExcep {
    return pqrsDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo PQRS (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<PQRS> getAll() throws ConnectionExcep {
    List<PQRS> pqrs = pqrsDAO.getAll();
    return pqrs;
  }

  /**
   *
   * @return Un entero de la consulta a PQRS (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public Integer getAllCount() throws ConnectionExcep {
    Integer countpqrs = pqrsDAO.getAllCount();
    return countpqrs;
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
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    pqrsDAO.delete(id);
  }
}
