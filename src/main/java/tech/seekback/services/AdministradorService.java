package tech.seekback.services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import tech.seekback.dao.interfaces.AdministradorDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

/**
 * @author gkentaurus
 */
@Stateless
public class AdministradorService {

  @EJB
  private AdministradorDAO administradorDAO;

  private final String column = "numeroDoc";

  /**
   * @param administrador
   * @return Retorna un objeto de tipo Administrador
   * @throws ConnectionExcep
   */
  public Usuario create(Usuario administrador) throws ConnectionExcep {
    if (this.administradorDAO.checkIfExist(administrador, column, administrador.getNumeroDoc())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return this.administradorDAO.create(administrador);
  }

  public List<Usuario> create(List<Usuario> listaAdministrador) throws ConnectionExcep {
    List<Usuario> errors = new ArrayList<>();
    for (Usuario administrador : listaAdministrador) {
      if (!this.administradorDAO.checkIfExist(administrador, column, administrador.getNumeroDoc())) {
        this.administradorDAO.create(administrador);
      } else {
        errors.add(administrador);
      }
    }
    return errors;
  }

  /**
   * @param id
   * @return Un objeto de tipo Administrador consultado por el id
   * @throws ConnectionExcep
   */
  public Usuario getOne(Integer id) throws ConnectionExcep {
    return administradorDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Administrador (referente al DAO que lo implemente)
   * @throws ConnectionExcep
   */
  public List<Usuario> getAll() throws ConnectionExcep {
    return administradorDAO.getAll();
  }

  /**
   * Actualiza un objeto de tipo Administrador
   *
   * @param administrador
   * @throws ConnectionExcep
   */
  public void update(Usuario administrador) throws ConnectionExcep {
    administradorDAO.update(administrador);
  }

  /**
   * Elimina un objeto de tipo Administrador consultado por el id
   *
   * @param administrador
   * @throws ConnectionExcep
   */
  public void delete(Usuario administrador) throws ConnectionExcep {
    administradorDAO.delete(administrador);
  }
}
