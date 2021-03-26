
package tech.seekback.services;

import tech.seekback.dao.interfaces.CiudadDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Ciudad;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author danny
 */
@Stateless
public class CiudadService {

  @EJB
  private CiudadDAO ciudadDAO;

  /**
   * @param ciudad
   * @return Un objeto de tipo Ciudad
   * @throws ConnectionExcep
   */
  public Ciudad create(Ciudad ciudad) throws ConnectionExcep {
    return ciudadDAO.create(ciudad);
  }

  /**
   * @param id
   * @return Un objeto de tipo Ciudad consultado por id
   * @throws ConnectionExcep
   */
  public Ciudad getOne(Integer id) throws ConnectionExcep {
    return ciudadDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Ciudad (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Ciudad> getAll() throws ConnectionExcep {
    List<Ciudad> ciudades = ciudadDAO.getAll();
    return ciudades;
  }

  /**
   * @param idDepartamento
   * @return Una colección de objetos de tipo Ciudad consultados por idDepartamento
   * @throws ConnectionExcep
   */
  public List<Ciudad> getByIdDepartamento(Integer idDepartamento) throws ConnectionExcep {
    System.out.println("pues eso " + idDepartamento);
    List<Ciudad> ciudades = ciudadDAO.getByIdDepartamento(idDepartamento);
    return ciudades;
  }

  /**
   * Actualiza un objeto de tipo Ciudad
   *
   * @param ciudad
   * @throws ConnectionExcep
   */
  public void update(Ciudad ciudad) throws ConnectionExcep {
    ciudadDAO.update(ciudad);
  }

  /**
   * Elimina un objeto de tipo Ciudad
   *
   * @param ciudad
   * @throws ConnectionExcep
   */
  public void delete(Ciudad ciudad) throws ConnectionExcep {
    ciudadDAO.delete(ciudad);
  }
}
