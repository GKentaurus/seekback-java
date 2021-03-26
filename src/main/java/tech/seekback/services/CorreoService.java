
package tech.seekback.services;

import tech.seekback.dao.interfaces.CorreoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correo;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author danny
 */
@Stateless
public class CorreoService {

  @EJB
  private CorreoDAO correosDAO;

  /**
   * @param correos
   * @return Un objeto de tipo Correo
   * @throws ConnectionExcep
   */
  public Correo create(Correo correos) throws ConnectionExcep {
    return correosDAO.create(correos);
  }

  /**
   * @param id
   * @return Un objeto de tipo Correo consultado por el id
   * @throws ConnectionExcep
   */
  public Correo getOne(Integer id) throws ConnectionExcep {
    return correosDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Correo (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<Correo> getAll() throws ConnectionExcep {
    List<Correo> correos = correosDAO.getAll();
    return correos;
  }

  /**
   * @param correo
   * @return Una colección de objetos de tipo Correo consultados por correo
   * @throws ConnectionExcep
   */
  public Correo getByCorreo(String correo) throws ConnectionExcep {
    return correosDAO.getByCorreo(correo);
  }

  /**
   * @param idUsuario
   * @return Una colección de objetos de tipo Correo consultados por correo
   * @throws ConnectionExcep
   */
  public Correo getByIdPrincipal(Integer idUsuario) throws ConnectionExcep {
    return correosDAO.getByIdPrincipal(idUsuario);
  }

  /**
   * Actualiza un objeto de tipo Correo
   *
   * @param correo
   * @throws ConnectionExcep
   */
  public void update(Correo correo) throws ConnectionExcep {
    correosDAO.update(correo);
  }

  /**
   * Elimina un objeto de tipo Correo
   *
   * @param correo
   * @throws ConnectionExcep
   */
  public void delete(Correo correo) throws ConnectionExcep {
    correosDAO.delete(correo);
  }
}
