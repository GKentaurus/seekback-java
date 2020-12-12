/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.TRMDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TRM;

/**
 *
 * @author camorenoc
 */
@Stateless
public class TRMService {

  @EJB
  private TRMDAO trmDao;

  /**
   *
   * @param trm
   * @return Un objeto de tipo TRM
   * @throws ConnectionExcep
   */
  public TRM create(TRM trm) throws ConnectionExcep {
    return trmDao.create(trm);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo TRM consultado por id
   * @throws ConnectionExcep
   */
  public TRM getOne(Integer id) throws ConnectionExcep {
    return trmDao.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo TRM (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<TRM> getAll() throws ConnectionExcep {
    List<TRM> trms = trmDao.getAll();
    return trms;
  }

  /**
   * Actualiza un objeto de tipo TRM
   *
   * @param trm
   * @throws ConnectionExcep
   */
  public void update(TRM trm) throws ConnectionExcep {
    trmDao.update(trm);
  }

  /**
   * Elimina un objeto de tipo TRM
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    trmDao.delete(id);
  }
}
