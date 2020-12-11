/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.AgendaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Agenda;

/**
 *
 * @author camorenoc
 */
@Stateless
public class AgendaService {

  @EJB

  private AgendaDAO agendaDAO;

  public Agenda create(Agenda agenda) throws ConnectionExcep {
    return agendaDAO.create(agenda);
  }

  public Agenda getOne(Integer id) throws ConnectionExcep {
    return agendaDAO.getOne(id);
  }

  public List<Agenda> getAll() throws ConnectionExcep {
    return agendaDAO.getAll();
  }

  public void update(Agenda agenda) throws ConnectionExcep {
    agendaDAO.update(agenda);
  }

  public void delete(Integer id) throws ConnectionExcep {
    agendaDAO.delete(id);
  }
}
