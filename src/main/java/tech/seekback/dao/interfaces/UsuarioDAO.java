
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.models.Usuario;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface UsuarioDAO extends DAO<Usuario, Integer> {
  //
}
