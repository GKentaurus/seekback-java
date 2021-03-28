
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Calificacion;

import javax.ejb.Local;
import java.util.List;

/**
 * @author gkentaurus
 */
@Local
public interface CalificacionDAO extends DAO<Calificacion, Integer> {
  List<Calificacion> getByIdProducto(int idProducto) throws ConnectionExcep;
  //
}
