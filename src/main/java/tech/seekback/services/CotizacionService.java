package tech.seekback.services;

import tech.seekback.dao.interfaces.CotizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cotizacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class CotizacionService {

  @EJB

  private CotizacionDAO cotizacionDAO;

  /**
   * @param cotizacion
   * @return Un objeto de tipo cotizacion
   * @throws ConnectionExcep
   */
  public Cotizacion create(Cotizacion cotizacion) throws ConnectionExcep {
    return cotizacionDAO.create(cotizacion);
  }

  /**
   * @param id
   * @return Un objeto de tipo Cotizacion consultado por el id
   * @throws ConnectionExcep
   */
  public Cotizacion getOne(Integer id) throws ConnectionExcep {
    return cotizacionDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Cotizacion (referente al Dao que
   * lo implementa)
   * @throws ConnectionExcep
   */
  public List<Cotizacion> getAll() throws ConnectionExcep {
    return cotizacionDAO.getAll();
  }

  public List<Cotizacion> getByIdEmpleado(Integer idEmpleado) throws ConnectionExcep {
    List<Cotizacion> cotizaciones = cotizacionDAO.getByIdEmpleado(idEmpleado);
    return cotizaciones;
  }

  public List<Cotizacion> getByIdCliente(Integer idCliente) throws ConnectionExcep {
    List<Cotizacion> cotizacionesByIdCliente = cotizacionDAO.getByIdCliente(idCliente);
    return cotizacionesByIdCliente;
  }

  /**
   * Actualiza un objeto de tipo Cotizacion
   *
   * @param cotizacion
   * @throws ConnectionExcep
   */
  public void update(Cotizacion cotizacion) throws ConnectionExcep {
    cotizacionDAO.update(cotizacion);
  }

  /**
   * Elimina un objeto de tipo Cotizacion
   *
   * @param cotizacion
   * @throws ConnectionExcep
   */
  public void delete(Cotizacion cotizacion) throws ConnectionExcep {
    cotizacionDAO.delete(cotizacion);
  }
}
