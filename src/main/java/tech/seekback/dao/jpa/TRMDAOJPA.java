
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TRMDAO;
import tech.seekback.models.TRM;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class TRMDAOJPA extends GenericDAO<TRM, Integer> implements TRMDAO {

  public TRMDAOJPA() {
    super(TRM.class);
  }
}
