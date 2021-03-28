
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.EstadosAgendaDAO;
import tech.seekback.models.EstadosAgenda;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class EstadosAgendaDAOJPA extends GenericDAO<EstadosAgenda, Integer> implements EstadosAgendaDAO {

  public EstadosAgendaDAOJPA() {
    super(EstadosAgenda.class);
  }
}
