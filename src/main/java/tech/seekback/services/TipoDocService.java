/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tech.seekback.dao.interfaces.TipoDocDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoDoc;

/**
 *
 * @author camorenoc
 */
@Stateless
public class TipoDocService {

  @EJB
  private TipoDocDAO tipoDocDAO;

  /**
   *
   * @param tipoDoc
   * @return Un objeto de tipo TipoDoc consultado por id
   * @throws ConnectionExcep
   */
  public TipoDoc create(TipoDoc tipoDoc) throws ConnectionExcep {
    return tipoDocDAO.create(tipoDoc);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo TipoDoc consultado por id
   * @throws ConnectionExcep
   */
  public TipoDoc getOne(Integer id) throws ConnectionExcep {
    return tipoDocDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo TipoDoc (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<TipoDoc> getAll() throws ConnectionExcep {
    List<TipoDoc> tipoDoc = tipoDocDAO.getAll();
    return tipoDoc;
  }

  /**
   * Actualiza un objeto de tipo TipoDoc
   *
   * @param tipoDoc
   * @throws ConnectionExcep
   */
  public void update(TipoDoc tipoDoc) throws ConnectionExcep {
    tipoDocDAO.update(tipoDoc);
  }

  /**
   * Elimina un objeto de tipo TipoDoc
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    tipoDocDAO.delete(id);
  }
}
