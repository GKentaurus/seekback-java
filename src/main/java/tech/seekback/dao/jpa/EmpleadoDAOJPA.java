package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.EmpleadoDAO;
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
public class EmpleadoDAOJPA extends GenericDAO<Usuario, Integer> implements EmpleadoDAO {

  public EmpleadoDAOJPA() {
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
      return em
              .createNamedQuery("Empleado.getOne", classType)
              .setParameter("idEmpleado", id)
              .getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  /**
   *
   * @return @throws ConnectionExcep
   */
  @Override
  public List<Usuario> getAll() throws ConnectionExcep {
    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t Consultando todos los objetos de Empleado"
            + "\n######################################################################\n"
    );
    TypedQuery<Usuario> tq = em.createNamedQuery("Empleado.getAll", classType);
    return tq.getResultList();
  }
}
