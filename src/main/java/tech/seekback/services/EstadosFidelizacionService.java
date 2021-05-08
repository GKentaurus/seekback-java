
package tech.seekback.services;

import tech.seekback.dao.interfaces.EstadosFidelizacionDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosAgenda;
import tech.seekback.models.EstadosFidelizacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class EstadosFidelizacionService {

  @EJB
  private EstadosFidelizacionDAO estadosFidelizacionDAO;

  private final String column = "nombreEstado";

  /**
   * @param estadosFidelizacion
   * @return Un objeto de tipo EstadosAgenda
   * @throws ConnectionExcep
   */
  public EstadosFidelizacion create(EstadosFidelizacion estadosFidelizacion) throws ConnectionExcep {
    if (this.estadosFidelizacionDAO.checkIfExist(estadosFidelizacion, this.column, estadosFidelizacion.getNombreEstado())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return estadosFidelizacionDAO.create(estadosFidelizacion);
  }

  public void create(List<EstadosFidelizacion> listaEstadosFidelizacion) throws ConnectionExcep {
    for (EstadosFidelizacion estadosFidelizacion : listaEstadosFidelizacion) {
      if (this.estadosFidelizacionDAO.checkIfExist(estadosFidelizacion, this.column, estadosFidelizacion.getNombreEstado())) {
        throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
      }
    }
    estadosFidelizacionDAO.create(listaEstadosFidelizacion);
  }

  /**
   * @param id
   * @return Un objeto de tipo EstadosFidelizacion consultado por id
   * @throws ConnectionExcep
   */
  public EstadosFidelizacion getOne(Integer id) throws ConnectionExcep {
    return estadosFidelizacionDAO.getOne(id);
  }

  /**
   * Una colección de objetos de tipo EstadosFidelizacion (referente al Dao que lo implementa)
   *
   * @return @throws ConnectionExcep
   */
  public List<EstadosFidelizacion> getAll() throws ConnectionExcep {
    List<EstadosFidelizacion> estadosFidelizaciones = estadosFidelizacionDAO.getAll();
    return estadosFidelizaciones;
  }

  /**
   * Actualiza un objeto de tipo EstadosFidelizacion
   *
   * @param estadosFidelizacion
   * @throws ConnectionExcep
   */
  public void update(EstadosFidelizacion estadosFidelizacion) throws ConnectionExcep {
    estadosFidelizacionDAO.update(estadosFidelizacion);
  }

  /**
   * Elimina un objeto de tipo EstadosFidelizacion
   *
   * @param estadosFidelizacion
   * @throws ConnectionExcep
   */
  public void delete(EstadosFidelizacion estadosFidelizacion) throws ConnectionExcep {
    estadosFidelizacionDAO.delete(estadosFidelizacion);
  }
}
