
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Departamento;

import javax.ejb.Local;
import java.util.List;

/**
 * @author gkentaurus
 */
@Local
public interface DepartamentoDAO extends DAO<Departamento, Integer> {
  List<Departamento> getByIdPais(Integer idPais) throws ConnectionExcep;
}
