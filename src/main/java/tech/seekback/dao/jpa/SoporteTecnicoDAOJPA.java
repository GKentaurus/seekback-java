package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.SoporteTecnicoDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.SoporteTecnico;

import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class SoporteTecnicoDAOJPA extends GenericDAO<SoporteTecnico, Integer> implements SoporteTecnicoDAO {

  public SoporteTecnicoDAOJPA() {
    super(SoporteTecnico.class);
  }

  /**
   * @return Un entero de la consulta COUNT de SoporteTecnico
   * @throws ConnectionExcep
   */
  @Override
  public Integer getAllCount() throws ConnectionExcep {
    try {
      Integer cont = ((Number) em.createNamedQuery("SoporteTecnico.getAllCount").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public List<SoporteTecnico> getByidEmpleado(Integer idEmpleado) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("SoporteTecnico.getByidEmpleado", classType)
              .setParameter("idEmpleado", idEmpleado)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public List<SoporteTecnico> getByidCliente(Integer idCliente) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("SoporteTecnico.getByidCliente", classType)
              .setParameter("idCliente", idCliente)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
