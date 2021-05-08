
package tech.seekback.services;

import tech.seekback.dao.interfaces.RolDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Rol;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class RolService {

  @EJB
  private RolDAO rolesDAO;

  private final String column = "nombreRol";

  /**
   * @param rol
   * @return Un objeto de tipo Rol
   * @throws ConnectionExcep
   */
  public Rol create(Rol rol) throws ConnectionExcep {
    if (this.rolesDAO.checkIfExist(rol, column, rol.getNombreRol())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return this.rolesDAO.create(rol);
  }

  public List<Rol> create(List<Rol> listaRols) throws ConnectionExcep {
    List<Rol> errors = new ArrayList<>();
    for (Rol rol : listaRols) {
      if (!this.rolesDAO.checkIfExist(rol, column, rol.getNombreRol())) {
        this.rolesDAO.create(rol);
      } else {
        errors.add(rol);
      }
    }
    return errors;
  }

  /**
   * @param id
   * @return Un objeto de tipo Rol consultado por id
   * @throws ConnectionExcep
   */
  public Rol getOne(Integer id) throws ConnectionExcep {
    return rolesDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Rol (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Rol> getAll() throws ConnectionExcep {
    List<Rol> roles = rolesDAO.getAll();
    return roles;
  }

  /**
   * Actualiza un objeto de tipo Rol
   *
   * @param rol
   * @throws ConnectionExcep
   */
  public void update(Rol rol) throws ConnectionExcep {
    rolesDAO.update(rol);
  }

  /**
   * Elimina un objeto de tipo Rol
   *
   * @param rol
   * @throws ConnectionExcep
   */
  public void delete(Rol rol) throws ConnectionExcep {
    rolesDAO.delete(rol);
  }
}
