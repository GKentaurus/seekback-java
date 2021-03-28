
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correo;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface CorreoDAO extends DAO<Correo, Integer> {
  Correo getByCorreo(String email) throws ConnectionExcep;
  Correo getByIdPrincipal(Integer idUsuario) throws ConnectionExcep;
  //
}
