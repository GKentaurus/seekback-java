package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CotizacionDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cotizacion;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class CotizacionDAOJPA extends GenericDAO<Cotizacion, Integer> implements CotizacionDAO {

  public CotizacionDAOJPA() {
    super(Cotizacion.class);
  }

  @Override
  public List<Cotizacion> getByIdEmpleado(Integer idEmpleado) throws ConnectionExcep {

    try {
      TypedQuery<Cotizacion> tq = em.createNamedQuery("Cotizacion.getByIdEmpleado", classType);
      tq.setParameter("idEmpleado", idEmpleado);
      return tq.getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public List<Cotizacion> getByIdCliente(Integer idCliente) throws ConnectionExcep {

    try {
      TypedQuery<Cotizacion> tq = em.createNamedQuery("Cotizacion.getByIdCliente", classType);
      tq.setParameter("idCliente", idCliente);
      return tq.getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
