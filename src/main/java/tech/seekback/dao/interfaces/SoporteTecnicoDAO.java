package tech.seekback.dao.interfaces;

import java.util.List;
import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.SoporteTecnico;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface SoporteTecnicoDAO extends DAO<SoporteTecnico, Integer> {

  Integer getAllCount() throws ConnectionExcep;

  List<SoporteTecnico> getByidEmpleado(Integer idEmpleado) throws ConnectionExcep;

  List<SoporteTecnico> getByidCliente(Integer idCliente) throws ConnectionExcep;
}
