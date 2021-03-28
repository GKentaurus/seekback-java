
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TipoDocDAO;
import tech.seekback.models.TipoDoc;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class TipoDocDAOJPA extends GenericDAO<TipoDoc, Integer> implements TipoDocDAO {

  public TipoDocDAOJPA() {
    super(TipoDoc.class);
  }
}
