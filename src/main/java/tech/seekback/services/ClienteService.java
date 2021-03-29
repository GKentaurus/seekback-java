
package tech.seekback.services;

import tech.seekback.dao.interfaces.ClienteDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class ClienteService {

  @EJB

  private ClienteDAO clienteDAO;

  /**
   * @param cliente
   * @return Un objeto de tipo Cliente
   * @throws ConnectionExcep
   */
  public Usuario create(Usuario cliente) throws ConnectionExcep {
    return clienteDAO.create(cliente);
  }

  /**
   * @param id
   * @return Un objeto de tipo Cliente consultado por id
   * @throws ConnectionExcep
   */
  public Usuario getOne(Integer id) throws ConnectionExcep {
    return clienteDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Cliente (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Usuario> getAll() throws ConnectionExcep {
    return clienteDAO.getAll();
  }

  /**
   * Actualiza un objeto de tipo Cliente
   *
   * @param cliente
   * @throws ConnectionExcep
   */
  public void update(Usuario cliente) throws ConnectionExcep {
    clienteDAO.update(cliente);
  }

  /**
   * Elimina un objeto de tipo Cliente
   *
   * @param cliente
   * @throws ConnectionExcep
   */
  public void delete(Usuario cliente) throws ConnectionExcep {
    clienteDAO.delete(cliente);
  }
}
