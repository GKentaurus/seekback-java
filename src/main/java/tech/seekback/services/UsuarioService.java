package tech.seekback.services;

import tech.seekback.dao.interfaces.UsuarioDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class UsuarioService {

  @EJB
  private UsuarioDAO usuarioDAO;

  private final String column = "numeroDoc";

  /**
   * @param usuario
   * @return Un objeto de tipo Usuario
   * @throws ConnectionExcep
   */
  public Usuario create(Usuario usuario) throws ConnectionExcep {
    if (this.usuarioDAO.checkIfExist(usuario, column, usuario.getNumeroDoc())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return this.usuarioDAO.create(usuario);
  }

  public List<Usuario> create(List<Usuario> listaClientes) throws ConnectionExcep {
    List<Usuario> errors = new ArrayList<>();
    for (Usuario usuario : listaClientes) {
      if (!this.usuarioDAO.checkIfExist(usuario, column, usuario.getNumeroDoc())) {
        this.usuarioDAO.create(usuario);
      } else {
        errors.add(usuario);
      }
    }
    return errors;
  }

  /**
   * @param id
   * @return Un ojeto de tipo Usuario consultado por id
   * @throws ConnectionExcep
   */
  public Usuario getOne(Integer id) throws ConnectionExcep {
    return usuarioDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Usuario (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<Usuario> getAll() throws ConnectionExcep {
    List<Usuario> usuarios = usuarioDAO.getAll();
    return usuarios;
  }

  /**
   * Actualiza un objeto de tipo Usuario
   *
   * @param usuario
   * @throws ConnectionExcep
   */
  public void update(Usuario usuario) throws ConnectionExcep {
    usuarioDAO.update(usuario);
  }

  /**
   * Elimina un objeto de tipo Usuario
   *
   * @param usuario
   * @throws ConnectionExcep
   */
  public void delete(Usuario usuario) throws ConnectionExcep {
    usuarioDAO.delete(usuario);
  }

}
