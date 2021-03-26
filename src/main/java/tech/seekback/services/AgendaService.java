
package tech.seekback.services;

import tech.seekback.dao.interfaces.AgendaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Agenda;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class AgendaService {

  @EJB

  private AgendaDAO agendaDAO;

  /**
   * @param agenda
   * @return Retorna un objeto de tipo Agenda
   * @throws ConnectionExcep
   */
  public Agenda create(Agenda agenda) throws ConnectionExcep {
    return agendaDAO.create(agenda);
  }

  /**
   * @param id
   * @return Un objeto de tipo Agenda consultado por el id
   * @throws ConnectionExcep
   */
  public Agenda getOne(Integer id) throws ConnectionExcep {
    return agendaDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Agenda (referente al DAO que lo implemente)
   * @throws ConnectionExcep
   */
  public List<Agenda> getAll() throws ConnectionExcep {
    return agendaDAO.getAll();
  }

  /**
   * Actualiza un objeto de tipo agenda
   *
   * @param agenda
   * @throws ConnectionExcep
   */
  public void update(Agenda agenda) throws ConnectionExcep {
    agendaDAO.update(agenda);
  }

  /**
   * Elimina un objeto de tipo Agenda
   *
   * @param agenda
   * @throws ConnectionExcep
   */
  public void delete(Agenda agenda) throws ConnectionExcep {
    agendaDAO.delete(agenda);
  }
}
