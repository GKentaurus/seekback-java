
package tech.seekback.services;

import tech.seekback.dao.interfaces.DireccionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Direccion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author danny
 */
@Stateless
public class DireccionService {

  @EJB
  private DireccionDAO direccionesDAO;

  /**
   * @param direciones
   * @return Un objeto de tipo Dirección
   * @throws ConnectionExcep
   */
  public Direccion create(Direccion direciones) throws ConnectionExcep {
    return direccionesDAO.create(direciones);
  }

  /**
   * @param id
   * @return Un objeto de tipo Dirección consultado por id
   * @throws ConnectionExcep
   */
  public Direccion getOne(Integer id) throws ConnectionExcep {
    return direccionesDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Dirección (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<Direccion> getAll() throws ConnectionExcep {
    List<Direccion> direcciones = direccionesDAO.getAll();
    return direcciones;
  }

  /**
   * @param idUsuario
   * @return Una colección de objetos de tipo Correo consultados por correo
   * @throws ConnectionExcep
   */
  public Direccion getByIdPrincipal(Integer idUsuario) throws ConnectionExcep {
    return direccionesDAO.getByIdPrincipal(idUsuario);
  }

  /**
   * Actualiza un objeto de tipo Dirección
   *
   * @param direccion
   * @throws ConnectionExcep
   */
  public void update(Direccion direccion) throws ConnectionExcep {
    direccionesDAO.update(direccion);
  }

  /**
   * Elimina un objeto de tipo Dirección
   *
   * @param direccion
   * @throws ConnectionExcep
   */
  public void delete(Direccion direccion) throws ConnectionExcep {
    direccionesDAO.delete(direccion);
  }
}
