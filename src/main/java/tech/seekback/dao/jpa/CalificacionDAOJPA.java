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
      TypedQuery<Calificacion> tq = em.createNamedQuery("Calificacion.getByIdProducto", classType);
      tq.setParameter("idProducto", idProducto);
      return tq.getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public List<Calificacion> getByidCliente(Integer idCliente) throws ConnectionExcep {
    try {
      TypedQuery<Calificacion> tq = em.createNamedQuery("Calificacion.getByidCliente", classType);
      tq.setParameter("idCliente", idCliente);
      return tq.getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public Integer getCalCountId(int idcalif) throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("Calificacion.getCalCount1").setParameter("idCalif", idcalif).getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public Integer getCalCount2() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("Calificacion.getCalCount2").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public Integer getCalCount3() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("Calificacion.getCalCount3").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public Integer getCalCount4() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("Calificacion.getCalCount4").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  @Override
  public Integer getCalCount5() throws ConnectionExcep {

    try {
      Integer cont = ((Number) em.createNamedQuery("Calificacion.getCalCount5").getSingleResult()).intValue();
      return cont;
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
