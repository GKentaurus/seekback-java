package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CiudadDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Ciudad;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class CiudadDAOJPA extends GenericDAO<Ciudad, Integer> implements CiudadDAO {

  public CiudadDAOJPA() {
    super(Ciudad.class);
  }

  @Override
  public List<Ciudad> getByIdDepartamento(Integer idDepartamento) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("Ciudad.getByIdDepartamento", classType)
              .setParameter("DepartamentoId", idDepartamento)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
