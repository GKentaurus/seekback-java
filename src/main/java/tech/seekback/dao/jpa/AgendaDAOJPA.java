package tech.seekback.dao.jpa;

import java.util.List;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.AgendaDAO;
import tech.seekback.models.Agenda;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;

/**
 * @author gkentaurus
 */
@Stateless
public class AgendaDAOJPA extends GenericDAO<Agenda, Integer> implements AgendaDAO {

  public AgendaDAOJPA() {
    super(Agenda.class);
  }

  @Override
  public List<Agenda> getByidEmpleado(Integer idEmpleado) throws ConnectionExcep {
    try {
      TypedQuery<Agenda> tq = em.createNamedQuery("Agenda.getByidEmpleado", classType);
      tq.setParameter("idEmpleado", idEmpleado);
      return tq.getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public List<Agenda> getByidCliente(Integer idCliente) throws ConnectionExcep {
    try {
      TypedQuery<Agenda> tq = em.createNamedQuery("Agenda.getByidCliente", classType);
      tq.setParameter("idCliente", idCliente);
      return tq.getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
