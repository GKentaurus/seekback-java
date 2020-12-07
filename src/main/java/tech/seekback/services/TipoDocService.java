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

  public void create(TipoDoc tipoDoc) throws ConnectionExcep {
    tipoDocDAO.create(tipoDoc);
  }

  public TipoDoc getOne(Integer id) throws ConnectionExcep {
    return tipoDocDAO.getOne(id);
  }

  public List<TipoDoc> getAll() throws ConnectionExcep {
    List<TipoDoc> tipoDoc = tipoDocDAO.getAll();
    return tipoDoc;
  }

  public void update(TipoDoc tipoDoc) throws ConnectionExcep {
    tipoDocDAO.update(tipoDoc);
  }

  public void delete(Integer id) throws ConnectionExcep {
    tipoDocDAO.delete(id);
  }
}
