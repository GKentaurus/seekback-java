
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.AdministradorDAO;
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
public class AdministradorDAOJPA extends GenericDAO<Usuario, Integer> implements AdministradorDAO {

  public AdministradorDAOJPA() {
    super(Usuario.class);
  }

  /**
   * @param id del Usuario
   * @return Un objeto de tipo Administrador
   * @throws ConnectionExcep
   */
  @Override
  public Usuario getOne(Integer id) throws ConnectionExcep {
    try {
      TypedQuery<Usuario> tq = em.createNamedQuery("Administrador.getOne", classType);
      tq.setParameter("idAdministrador", id);
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
        + "\n#\t Consultando todos los objetos de Administrador"
        + "\n######################################################################\n"
    );
    TypedQuery<Usuario> tq = em.createNamedQuery("Administrador.getAll", classType);
    return tq.getResultList();
  }
}
