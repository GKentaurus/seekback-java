package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tech.seekback.dao.interfaces.EstadosCotizacionDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosCotizacion;

/**
 * @author gkentaurus
 */
@Stateless
public class EstadosCotizacionService {

  @EJB
  private EstadosCotizacionDAO estadosCotizacionDAO;

  private final String column = "nombreEstado";

  /**
   * @param estadosCotizacion
   * @return Un objeto de tipo EstadosCotizacion
   * @throws ConnectionExcep
   */
  public EstadosCotizacion create(EstadosCotizacion estadosCotizacion) throws ConnectionExcep {
    if (this.estadosCotizacionDAO.checkIfExist(estadosCotizacion, this.column, estadosCotizacion.getNombreEstado())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return estadosCotizacionDAO.create(estadosCotizacion);
  }

  public void create(List<EstadosCotizacion> listaEstadosCotizacion) throws ConnectionExcep {
    for (EstadosCotizacion estadosCotizacion : listaEstadosCotizacion) {
      if (this.estadosCotizacionDAO.checkIfExist(estadosCotizacion, this.column, estadosCotizacion.getNombreEstado())) {
        throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
      }
    }
    estadosCotizacionDAO.create(listaEstadosCotizacion);
  }

  /**
   * @param id
   * @return Un objeto de tipo EstadosCotizacion consultado por id
   * @throws ConnectionExcep
   */
  public EstadosCotizacion getOne(Integer id) throws ConnectionExcep {
    return estadosCotizacionDAO.getOne(id);
  }

  /**
   * @param id
   * @return Una colección de objetos de tipo EstadosCotizacion consultado por id (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<EstadosCotizacion> getAll() throws ConnectionExcep {
    return estadosCotizacionDAO.getAll();
  }

  /**
   * Actualiza un objeto de tipo EstadosCotizacion
   *
   * @param estadosCotizacion
   * @throws ConnectionExcep
   */
  public void update(EstadosCotizacion estadosCotizacion) throws ConnectionExcep {
    estadosCotizacionDAO.update(estadosCotizacion);
  }

  /**
   * Elimina un objeto de tipo EstadosCotizacion
   *
   * @param estadosCotizacion
   * @throws ConnectionExcep
   */
  public void delete(EstadosCotizacion estadosCotizacion) throws ConnectionExcep {
    estadosCotizacionDAO.delete(estadosCotizacion);
  }
}
