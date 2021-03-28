
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.PaisDAO;
import tech.seekback.models.Pais;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class PaisDAOJPA extends GenericDAO<Pais, Integer> implements PaisDAO {

  public PaisDAOJPA() {
    super(Pais.class);
  }
}
