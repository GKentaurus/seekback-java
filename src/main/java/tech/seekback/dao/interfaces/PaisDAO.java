
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Pais;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface PaisDAO extends DAO<Pais, Integer> {
  void delete(Pais pais) throws ConnectionExcep;
}
