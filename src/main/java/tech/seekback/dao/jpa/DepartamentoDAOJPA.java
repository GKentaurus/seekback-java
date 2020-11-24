/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import com.sun.mail.iap.ConnectionException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.DepartamentoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Departamento;

/**
 *
 * @author camorenoc
 */
@Stateless
public class DepartamentoDAOJPA extends GenericDAO<Departamento, Integer> implements DepartamentoDAO {

  public DepartamentoDAOJPA() {
    super(Departamento.class);
  }

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
}
