/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.DepartamentoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Departamento;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 *
 * @author camorenoc
 */
@Stateless
public class DepartamentoDAOJPA extends GenericDAO<Departamento, Integer> implements DepartamentoDAO {

  public DepartamentoDAOJPA() {
    super(Departamento.class);
  }

  /**
   *
   * @param idPais
   * @return Un objeto de tipo departamento consultado por idPais
   * @throws ConnectionExcep
   */
  @Override
  public List<Departamento> getByIdPais(Integer idPais) throws ConnectionExcep {
    try {
      TypedQuery<Departamento> tq = em.createNamedQuery("Departamento.getByIdPais", classType);
      tq.setParameter("paisId", idPais);
      return tq.getResultList();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }

  /**
   * Elimina un objeto de tipo Departamento
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(Departamento obj) throws ConnectionExcep {
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Eliminando el objeto No. " + this.classType.getSimpleName()
        + "\n######################################################################\n"
    );
    Timestamps tt = obj.getTimestamps();
    tt.setDeleted(true);
    tt.setDeleted_at(new Date());
    obj.setTimestamps(tt);
    create(obj);
  }
}
