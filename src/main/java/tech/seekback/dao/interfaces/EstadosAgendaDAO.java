
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosAgenda;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface EstadosAgendaDAO extends DAO<EstadosAgenda, Integer> {
  void delete(EstadosAgenda estadosAgenda) throws ConnectionExcep;
}
