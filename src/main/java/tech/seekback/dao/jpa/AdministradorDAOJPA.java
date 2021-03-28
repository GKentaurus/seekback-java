
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.AdministradorDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Usuario;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

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
  public Usuario getByIdUsuario(Integer id) throws ConnectionExcep {

    try {
      TypedQuery<Usuario> tq = em.createNamedQuery("Administrador.getByIdAdministrador", classType);
      tq.setParameter("idAdministrador", id);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
