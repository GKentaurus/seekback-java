
package tech.seekback.services;

import tech.seekback.dao.interfaces.DepartamentoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Departamento;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author danny
 */
@Stateless
public class DepartamentoService {

  @EJB
  private DepartamentoDAO departamentoDAO;

  /**
   * @param departamento
   * @return Un objeto de tipo departamento
   * @throws ConnectionExcep
   */
  public Departamento create(Departamento departamento) throws ConnectionExcep {
    return departamentoDAO.create(departamento);
  }

  /**
   * @param id
   * @return Un objeto de tipo departamento consultado por id
   * @throws ConnectionExcep
   */
  public Departamento getOne(Integer id) throws ConnectionExcep {
    return departamentoDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Departamento (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Departamento> getAll() throws ConnectionExcep {
    List<Departamento> departamentos = departamentoDAO.getAll();
    return departamentos;
  }

  /**
   * @param idPais
   * @return Una colección de objetos de tipo Departamento consultado por idPais
   * @throws ConnectionExcep
   */
  public List<Departamento> getByIdPais(Integer idPais) throws ConnectionExcep {
    List<Departamento> departamentos = departamentoDAO.getByIdPais(idPais);
    return departamentos;
  }

  /**
   * Actualiza un objeto de tipo Departamento
   *
   * @param departamento
   * @throws ConnectionExcep
   */
  public void update(Departamento departamento) throws ConnectionExcep {
    departamentoDAO.update(departamento);
  }

  /**
   * Elimina un objeto de tipo Departamento
   *
   * @param departamento
   * @throws ConnectionExcep
   */
  public void delete(Departamento departamento) throws ConnectionExcep {
    departamentoDAO.delete(departamento);
  }
}
