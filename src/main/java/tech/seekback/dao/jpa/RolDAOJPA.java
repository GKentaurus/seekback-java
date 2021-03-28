
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.RolDAO;
import tech.seekback.models.Rol;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class RolDAOJPA extends GenericDAO<Rol, Integer> implements RolDAO {

  public RolDAOJPA() {
    super(Rol.class);
  }
}
