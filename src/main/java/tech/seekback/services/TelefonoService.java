
package tech.seekback.services;

import tech.seekback.dao.interfaces.TelefonoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Telefono;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class TelefonoService {

  @EJB
  private TelefonoDAO telefonoDAO;

  /**
   * @param telefono
   * @return Un objeto de tipo Telefono
   * @throws ConnectionExcep
   */
  public Telefono create(Telefono telefono) throws ConnectionExcep {
    return telefonoDAO.create(telefono);
  }

  /**
   * @param id
   * @return Un objeto de tipo Telefono consultado por id
   * @throws ConnectionExcep
   */
  public Telefono getOne(Integer id) throws ConnectionExcep {
    return telefonoDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Telefono (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<Telefono> getAll() throws ConnectionExcep {
    List<Telefono> telefonos = telefonoDAO.getAll();
    return telefonos;
  }

  /**
   * @param IdUsuario
   * @return Una colección de objetos de tipo Telefono consultados por IdUsuario
   * @throws ConnectionExcep
   */
  public Telefono getByIdUsuario(Integer IdUsuario) throws ConnectionExcep {
    return telefonoDAO.getByIdUsuario(IdUsuario);
  }

  /**
   * @param IdUsuario
   * @return Una colección de objetos de tipo Telefono consultados por IdUsuario
   * @throws ConnectionExcep
   */
  public Telefono getByIdPrincipal(Integer IdUsuario) throws ConnectionExcep {
    return telefonoDAO.getByIdPrincipal(IdUsuario);
  }

  /**
   * Actualiza un objeto de tipo Telefono
   *
   * @param telefono
   * @throws ConnectionExcep
   */
  public void update(Telefono telefono) throws ConnectionExcep {
    telefonoDAO.update(telefono);
  }

  /**
   * Elimina un objeto de tipo Telefono
   *
   * @param telefono
   * @throws ConnectionExcep
   */
  public void delete(Telefono telefono) throws ConnectionExcep {
    telefonoDAO.delete(telefono);
  }

}
