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

  public TRM create(TRM trm) throws ConnectionExcep {
    return trmDao.create(trm);
  }

  public TRM getOne(Integer id) throws ConnectionExcep {
    return trmDao.getOne(id);
  }

  public List<TRM> getAll() throws ConnectionExcep {
    List<TRM> trms = trmDao.getAll();
    return trms;
  }

  public void update(TRM trm) throws ConnectionExcep {
    trmDao.update(trm);
  }

  public void delete(Integer id) throws ConnectionExcep {
    trmDao.delete(id);
  }
}
