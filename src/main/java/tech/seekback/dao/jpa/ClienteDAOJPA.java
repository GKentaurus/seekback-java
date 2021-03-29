
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ClienteDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

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
  public Usuario getOne(Integer id) throws ConnectionExcep {

    try {
      TypedQuery<Usuario> tq = em.createNamedQuery("Cliente.getOne", classType);
      tq.setParameter("idCliente", id);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  /**
   *
   * @return
   * @throws ConnectionExcep
   */
  @Override
  public List<Usuario> getAll() throws ConnectionExcep {
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Consultando todos los objetos de Cliente"
        + "\n######################################################################\n"
    );
    TypedQuery<Usuario> tq = em.createNamedQuery("Cliente.getAll", classType);
    return tq.getResultList();
  }
}
