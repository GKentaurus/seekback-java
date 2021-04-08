package tech.seekback.dao.interfaces;

import java.util.List;
import tech.seekback.dao.DAO;
import tech.seekback.models.Agenda;

import javax.ejb.Local;
import tech.seekback.exceptions.ConnectionExcep;

/**
 * @author gkentaurus
 */
@Local
public interface AgendaDAO extends DAO<Agenda, Integer> {

  //
  List<Agenda> getByidEmpleado(Integer idEmpleado) throws ConnectionExcep;

  List<Agenda> getByidCliente(Integer idCliente) throws ConnectionExcep;
}
