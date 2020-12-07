/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.PaisDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Pais;

/**
 *
 * @author danny
 */
@Stateless
public class PaisService {

  @EJB
  private PaisDAO paisDAO;

  public void create(Pais pais) throws ConnectionExcep {
    paisDAO.create(pais);
  }

  public Pais getOne(Integer id) throws ConnectionExcep {
    return paisDAO.getOne(id);
  }

  public List<Pais> getAll() throws ConnectionExcep {
    List<Pais> tipoDoc = paisDAO.getAll();
    return tipoDoc;
  }

  public void update(Pais pais) throws ConnectionExcep {
    paisDAO.update(pais);
  }

  public void delete(Integer id) throws ConnectionExcep {
    paisDAO.delete(id);
  }
}
