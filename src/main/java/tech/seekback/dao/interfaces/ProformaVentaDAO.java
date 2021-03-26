
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.ProformaVenta;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface ProformaVentaDAO extends DAO<ProformaVenta, Integer> {
  void delete(ProformaVenta proformaVenta) throws ConnectionExcep;
}
