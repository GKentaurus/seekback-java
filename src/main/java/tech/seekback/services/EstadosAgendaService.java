/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.EstadosAgendaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosAgenda;

/**
 *
 * @author camorenoc
 */
@Stateless
public class EstadosAgendaService {

  @EJB

  private EstadosAgendaDAO estadosAgendaDAO;

  public void create(EstadosAgenda estadosAgenda) throws ConnectionExcep {
    estadosAgendaDAO.create(estadosAgenda);
  }

  public EstadosAgenda getOne(Integer id) throws ConnectionExcep {
    return estadosAgendaDAO.getOne(id);
  }

  public List<EstadosAgenda> getAll() throws ConnectionExcep {
    return estadosAgendaDAO.getAll();
  }

  public void update(EstadosAgenda estadosAgenda) throws ConnectionExcep {
    estadosAgendaDAO.update(estadosAgenda);
  }

  public void delete(Integer id) throws ConnectionExcep {
    estadosAgendaDAO.delete(id);
  }
}
