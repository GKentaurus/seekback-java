
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.SoporteTecnico;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface SoporteTecnicoDAO extends DAO<SoporteTecnico, Integer> {
  Integer getAllCount() throws ConnectionExcep;
  void delete(SoporteTecnico soporteTecnico) throws ConnectionExcep;
}
