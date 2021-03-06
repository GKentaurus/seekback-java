package tech.seekback.dao.interfaces;

import java.util.List;
import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.PQRS;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface PQRSDAO extends DAO<PQRS, Integer> {

  Integer getAllCount() throws ConnectionExcep;

  List<PQRS> getByCliente(Integer idCliente) throws ConnectionExcep;
}
