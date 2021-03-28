
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.DivisaDAO;
import tech.seekback.models.Divisa;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class DivisaDAOJPA extends GenericDAO<Divisa, Integer> implements DivisaDAO {

  public DivisaDAOJPA() {
    super(Divisa.class);
  }
}
