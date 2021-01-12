/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import tech.seekback.dao.interfaces.EstadosAgendaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosAgenda;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author camorenoc
 */
@Stateless
public class EstadosAgendaService {

  @EJB

  private EstadosAgendaDAO estadosAgendaDAO;

  /**
   * @param estadosAgenda
   * @return Un objeto de tipo EstadosAgenda
   * @throws ConnectionExcep
   */
  public EstadosAgenda create(EstadosAgenda estadosAgenda) throws ConnectionExcep {
    return estadosAgendaDAO.create(estadosAgenda);
  }

  /**
   * @param id
   * @return Un objeto de tipo EstadosAgenda consultado por id
   * @throws ConnectionExcep
   */
  public EstadosAgenda getOne(Integer id) throws ConnectionExcep {
    return estadosAgendaDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo EstadosAgenda (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<EstadosAgenda> getAll() throws ConnectionExcep {
    return estadosAgendaDAO.getAll();
  }

  /**
   * Actualiza un objeto de tipo EstadosAgenda
   *
   * @param estadosAgenda
   * @throws ConnectionExcep
   */
  public void update(EstadosAgenda estadosAgenda) throws ConnectionExcep {
    estadosAgendaDAO.update(estadosAgenda);
  }

  /**
   * Elimina un objeto de tipo EstadosAgenda
   *
   * @param estadosAgenda
   * @throws ConnectionExcep
   */
  public void delete(EstadosAgenda estadosAgenda) throws ConnectionExcep {
    estadosAgendaDAO.delete(estadosAgenda);
  }
}