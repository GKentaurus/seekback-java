
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cotizacion;

import javax.ejb.Local;
import java.util.List;

/**
 * @author gkentaurus
 */
@Local
public interface CotizacionDAO extends DAO<Cotizacion, Integer> {

  void delete(Cotizacion cotizacion) throws ConnectionExcep;

  List<Cotizacion> getByIdEmpleado(Integer idEmpleado) throws ConnectionExcep;
}
