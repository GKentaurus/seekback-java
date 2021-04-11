package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.DepartamentoDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Departamento;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class DepartamentoDAOJPA extends GenericDAO<Departamento, Integer> implements DepartamentoDAO {

  public DepartamentoDAOJPA() {
    super(Departamento.class);
  }

  /**
   * @param idPais
   * @return Un objeto de tipo departamento consultado por idPais
   * @throws ConnectionExcep
   */
  @Override
  public List<Departamento> getByIdPais(Integer idPais) throws ConnectionExcep {
    try {
      return em
              .createNamedQuery("Departamento.getByIdPais", classType)
              .setParameter("paisId", idPais)
              .getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
