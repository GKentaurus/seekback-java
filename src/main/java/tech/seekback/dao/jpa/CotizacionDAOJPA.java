
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CotizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Cotizacion;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Date;
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

  /**
   * Elimina un objeto de tipo Cotizacion
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(Cotizacion obj) throws ConnectionExcep {
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Eliminando el objeto No. " + this.classType.getSimpleName()
        + "\n######################################################################\n"
    );
    Timestamps tt = obj.getTimestamps();
    tt.setDeleted(true);
    tt.setDeleted_at(new Date());
    obj.setTimestamps(tt);
    create(obj);
  }
}
