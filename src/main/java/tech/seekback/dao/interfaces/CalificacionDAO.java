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

  Integer getCalCountId(int idcalif) throws ConnectionExcep;

  Integer getCalCount2() throws ConnectionExcep;

  Integer getCalCount3() throws ConnectionExcep;

  Integer getCalCount4() throws ConnectionExcep;

  Integer getCalCount5() throws ConnectionExcep;
  //
}
