/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.DivisaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Divisa;

/**
 *
 * @author camorenoc
 */
@Stateless
public class DivisaService {

  @EJB

  private DivisaDAO divisaDAO;

  /**
   *
   * @param divisa
   * @return Un objeto de tipo Divisa
   * @throws ConnectionExcep
   */
  public Divisa create(Divisa divisa) throws ConnectionExcep {
    return divisaDAO.create(divisa);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo Divisa consultado por id
   * @throws ConnectionExcep
   */
  public Divisa getOne(Integer id) throws ConnectionExcep {
    return divisaDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo Divisa (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Divisa> getAll() throws ConnectionExcep {
    return divisaDAO.getAll();
  }

  /**
   * Actualiza un objeto de tipo Divisa
   *
   * @param divisa
   * @throws ConnectionExcep
   */
  public void update(Divisa divisa) throws ConnectionExcep {
    divisaDAO.update(divisa);
  }

  /**
   * Elimina un objeto de tipo Divisa
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    divisaDAO.delete(id);
  }
}
