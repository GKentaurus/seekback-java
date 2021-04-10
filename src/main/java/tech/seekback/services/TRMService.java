package tech.seekback.services;

import tech.seekback.dao.interfaces.TRMDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TRM;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class TRMService {

  @EJB
  private TRMDAO trmDao;

  /**
   * @param trm
   * @return Un objeto de tipo TRM
   * @throws ConnectionExcep
   */
  public TRM create(TRM trm) throws ConnectionExcep {
    return trmDao.create(trm);
  }

  /**
   * @param id
   * @return Un objeto de tipo TRM consultado por id
   * @throws ConnectionExcep
   */
  public TRM getOne(Integer id) throws ConnectionExcep {
    return trmDao.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo TRM (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<TRM> getAll() throws ConnectionExcep {
    List<TRM> trms = trmDao.getAll();
    return trms;
  }

  public List<TRM> getByidDivisa(Integer idDivisa) throws ConnectionExcep {
    List<TRM> trmsByidDivisa = trmDao.getByidDivisa(idDivisa);
    return trmsByidDivisa;
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
   * @param trm
   * @throws ConnectionExcep
   */
  public void delete(TRM trm) throws ConnectionExcep {
    trmDao.delete(trm);
  }
}
