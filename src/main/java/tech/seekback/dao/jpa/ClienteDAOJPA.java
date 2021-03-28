
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ClienteDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Usuario;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * @author gkentaurus
 */
@Stateless
public class ClienteDAOJPA extends GenericDAO<Usuario, Integer> implements ClienteDAO {

  public ClienteDAOJPA() {
    super(Usuario.class);
  }

  /**
   * @param id del Usuario
   * @return Un objeto de tipo Cliente
   * @throws ConnectionExcep
   */
  @Override
  public Usuario getByIdUsuario(Integer id) throws ConnectionExcep {

    try {
      TypedQuery<Usuario> tq = em.createNamedQuery("Cliente.getByIdCliente", classType);
      tq.setParameter("idCliente", id);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
