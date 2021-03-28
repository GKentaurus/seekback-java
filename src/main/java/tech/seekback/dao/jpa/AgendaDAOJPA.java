
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.AgendaDAO;
import tech.seekback.models.Agenda;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class AgendaDAOJPA extends GenericDAO<Agenda, Integer> implements AgendaDAO {

  public AgendaDAOJPA() {
    super(Agenda.class);
  }
}
