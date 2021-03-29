
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

import javax.ejb.Local;
import java.util.List;

/**
 * @author gkentaurus
 */
@Local
public interface ClienteDAO extends DAO<Usuario, Integer> {
  Usuario getOne(Integer id) throws ConnectionExcep;
  List<Usuario> getAll() throws ConnectionExcep;
}
