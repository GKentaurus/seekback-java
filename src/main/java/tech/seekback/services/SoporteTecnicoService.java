/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import tech.seekback.dao.interfaces.SoporteTecnicoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.SoporteTecnico;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author camorenoc
 */
@Stateless
public class SoporteTecnicoService {

  @EJB
  private SoporteTecnicoDAO soporteTecnicoDAO;

  /**
   * @param soporteTecnico
   * @return Un objeto de tipo SoporteTecnico
   * @throws ConnectionExcep
   */
  public SoporteTecnico create(SoporteTecnico soporteTecnico) throws ConnectionExcep {
    return soporteTecnicoDAO.create(soporteTecnico);
  }

  /**
   * @param id
   * @return Un objeto de tipo SoporteTecnico consultado por id
   * @throws ConnectionExcep
   */
  public SoporteTecnico getOne(Integer id) throws ConnectionExcep {
    return soporteTecnicoDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Rol (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<SoporteTecnico> getAll() throws ConnectionExcep {
    List<SoporteTecnico> seportesTecnicos = soporteTecnicoDAO.getAll();
    return seportesTecnicos;
  }

  /**
   * @return Un entero de la consulta a soporteTecnico (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public Integer getAllCount() throws ConnectionExcep {
    Integer countpqrs = soporteTecnicoDAO.getAllCount();
    return countpqrs;
  }

  /**
   * Actualiza un objeto de tipo soporteTecnico
   *
   * @param soporteTecnico
   * @throws ConnectionExcep
   */
  public void update(SoporteTecnico soporteTecnico) throws ConnectionExcep {
    soporteTecnicoDAO.update(soporteTecnico);
  }

  /**
   * Elimina un objeto de tipo soporteTecnico
   *
   * @param soporteTecnico
   * @throws ConnectionExcep
   */
  public void delete(SoporteTecnico soporteTecnico) throws ConnectionExcep {
    soporteTecnicoDAO.delete(soporteTecnico);
  }
}