package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CalificacionDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Calificacion;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class CalificacionDAOJPA extends GenericDAO<Calificacion, Integer> implements CalificacionDAO {

  public CalificacionDAOJPA() {
    super(Calificacion.class);
  }

  /**
   * @param idProducto
   * @return Un objeto de tipo Calificacion consultado por idProducto
   * @throws ConnectionExcep
   */
  @Override
  public List<Calificacion> getByIdProducto(int idProducto) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("Calificacion.getByIdProducto", classType)
              .setParameter("idProducto", idProducto)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public List<Calificacion> getByidCliente(Integer idCliente) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("Calificacion.getByidCliente", classType)
              .setParameter("idCliente", idCliente)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public Integer getCalCountId(int calificacion) throws ConnectionExcep {

    try {
      return ((Number) em
              .createNamedQuery("Calificacion.getCalCount")
              .setParameter("calificacion", calificacion)
              .getSingleResult())
              .intValue();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
