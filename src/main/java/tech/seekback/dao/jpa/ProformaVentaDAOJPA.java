
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ProformaVentaDAO;
import tech.seekback.models.ProformaVenta;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class ProformaVentaDAOJPA extends GenericDAO<ProformaVenta, Integer> implements ProformaVentaDAO {

  public ProformaVentaDAOJPA() {
    super(ProformaVenta.class);
  }
}
