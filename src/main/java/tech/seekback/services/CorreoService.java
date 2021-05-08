
package tech.seekback.services;

import tech.seekback.dao.interfaces.CorreoDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correo;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * @author danny
 */
@Stateless
public class CorreoService {

  @EJB
  private CorreoDAO correoDAO;

  private final String column = "correoElectronico";

  /**
   * @param correo
   * @return Un objeto de tipo Correo
   * @throws ConnectionExcep
   */
  public Correo create(Correo correo) throws ConnectionExcep {
    if (this.correoDAO.checkIfExist(correo, column, correo.getCorreoElectronico())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return this.correoDAO.create(correo);
  }

  public List<Correo> create(List<Correo> listaCorreos) throws ConnectionExcep {
    List<Correo> errors = new ArrayList<>();
    for (Correo correo : listaCorreos) {
      if (!this.correoDAO.checkIfExist(correo, column, correo.getCorreoElectronico())) {
        this.correoDAO.create(correo);
      } else {
        errors.add(correo);
      }
    }
    return errors;
  }

  /**
   * @param id
   * @return Un objeto de tipo Correo consultado por el id
   * @throws ConnectionExcep
   */
  public Correo getOne(Integer id) throws ConnectionExcep {
    return correoDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Correo (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<Correo> getAll() throws ConnectionExcep {
    return correoDAO.getAll();
  }

  /**
   * @param correo
   * @return Una colección de objetos de tipo Correo consultados por correo
   * @throws ConnectionExcep
   */
  public Correo getByCorreo(String correo) throws ConnectionExcep {
    return correoDAO.getByCorreo(correo);
  }

  /**
   * @param idUsuario
   * @return Una colección de objetos de tipo Correo consultados por correo
   * @throws ConnectionExcep
   */
  public Correo getByIdPrincipal(Integer idUsuario) throws ConnectionExcep {
    return correoDAO.getByIdPrincipal(idUsuario);
  }

  /**
   * Actualiza un objeto de tipo Correo
   *
   * @param correo
   * @throws ConnectionExcep
   */
  public void update(Correo correo) throws ConnectionExcep {
    correoDAO.update(correo);
  }

  /**
   * Elimina un objeto de tipo Correo
   *
   * @param correo
   * @throws ConnectionExcep
   */
  public void delete(Correo correo) throws ConnectionExcep {
    correoDAO.delete(correo);
  }
}
