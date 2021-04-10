package tech.seekback.services;

import tech.seekback.dao.interfaces.CalificacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Calificacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class CalificacionService {

  @EJB

  private CalificacionDAO calificacionDAO;

  /**
   * @param calificacion
   * @return Un objeto de tipo Calificacion
   * @throws ConnectionExcep
   */
  public Calificacion create(Calificacion calificacion) throws ConnectionExcep {
    return calificacionDAO.create(calificacion);
  }

  /**
   * @param id
   * @return Un objeto tipo Calificación consultado por od
   * @throws ConnectionExcep
   */
  public Calificacion getOne(Integer id) throws ConnectionExcep {
    return calificacionDAO.getOne(id);
  }

  /**
   * Una coleccion de objetos de tipo Calificación (referente al DAO que lo
   * implemente)
   *
   * @return @throws ConnectionExcep
   */
  public List<Calificacion> getAll() throws ConnectionExcep {
    return calificacionDAO.getAll();
  }

  public List<Calificacion> getByidCliente(Integer idCliente) throws ConnectionExcep {
    List<Calificacion> calificacionByidCliente = calificacionDAO.getByidCliente(idCliente);
    return calificacionByidCliente;
  }

  public Integer getCalCount(int calificacion) throws ConnectionExcep {
    return calificacionDAO.getCalCountId(calificacion);
  }

  /**
   * @param idProducto
   * @return Una colección de objetos de tipo Calificacion consultado por
   * idProducto
   * @throws ConnectionExcep
   */
  public List<Calificacion> getByIdProducto(int idProducto) throws ConnectionExcep {
    List<Calificacion> calificacions = calificacionDAO.getByIdProducto(idProducto);
    return calificacions;
  }

  /**
   * Actualiza un objeto de tipo Calificación
   *
   * @param calificacion
   * @throws ConnectionExcep
   */
  public void update(Calificacion calificacion) throws ConnectionExcep {
    calificacionDAO.update(calificacion);
  }

  /**
   * Elimina un objeto de tipo Calificación
   *
   * @param calificacion
   * @throws ConnectionExcep
   */
  public void delete(Calificacion calificacion) throws ConnectionExcep {
    calificacionDAO.delete(calificacion);
  }
}
