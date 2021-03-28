
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.models.Agenda;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface AgendaDAO extends DAO<Agenda, Integer> {
  //
}
