package tech.seekback.dao.interfaces;

import java.util.List;
import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Felicitacion;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface FelicitacionDAO extends DAO<Felicitacion, Integer> {

  Integer getAllCount() throws ConnectionExcep;

  List<Felicitacion> getByidCliente(Integer idCliente) throws ConnectionExcep;
}
