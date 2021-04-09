package tech.seekback.services;

import tech.seekback.dao.interfaces.SoporteTecnicoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.SoporteTecnico;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class SoporteTecnicoService {

  @EJB
  private SoporteTecnicoDAO soporteTecnicoDAO;

  /**
   * @param soporteTecnico
   * @return Un objeto de tipo SoporteTecnico
   * @throws ConnectionExcep
   */
  public SoporteTecnico create(SoporteTecnico soporteTecnico) throws ConnectionExcep {
    return soporteTecnicoDAO.create(soporteTecnico);
  }

  /**
   * @param id
   * @return Un objeto de tipo SoporteTecnico consultado por id
   * @throws ConnectionExcep
   */
  public SoporteTecnico getOne(Integer id) throws ConnectionExcep {
    return soporteTecnicoDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Rol (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<SoporteTecnico> getAll() throws ConnectionExcep {
    List<SoporteTecnico> seportesTecnicos = soporteTecnicoDAO.getAll();
    return seportesTecnicos;
  }

  public List<SoporteTecnico> getByidEmpleado(Integer idEmpleado) throws ConnectionExcep {
    List<SoporteTecnico> soportesTecnicosIdEmpleado = soporteTecnicoDAO.getByidEmpleado(idEmpleado);
    return soportesTecnicosIdEmpleado;
  }

  public List<SoporteTecnico> getByidCliente(Integer idCliente) throws ConnectionExcep {
    List<SoporteTecnico> soportesTecnicosIdCliente = soporteTecnicoDAO.getByidCliente(idCliente);
    return soportesTecnicosIdCliente;
  }

  /**
   * @return Un entero de la consulta a soporteTecnico (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public Integer getAllCount() throws ConnectionExcep {
    Integer countpqrs = soporteTecnicoDAO.getAllCount();
    return countpqrs;
  }

  /**
   * Actualiza un objeto de tipo soporteTecnico
   *
   * @param soporteTecnico
   * @throws ConnectionExcep
   */
  public void update(SoporteTecnico soporteTecnico) throws ConnectionExcep {
    soporteTecnicoDAO.update(soporteTecnico);
  }

  /**
   * Elimina un objeto de tipo soporteTecnico
   *
   * @param soporteTecnico
   * @throws ConnectionExcep
   */
  public void delete(SoporteTecnico soporteTecnico) throws ConnectionExcep {
    soporteTecnicoDAO.delete(soporteTecnico);
  }
}
