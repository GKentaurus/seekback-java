/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.SoporteTecnicoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.SoporteTecnico;

/**
 *
 * @author camorenoc
 */
@Stateless
public class SoporteTecnicoDAOJPA extends GenericDAO<SoporteTecnico, Integer> implements SoporteTecnicoDAO {

  public SoporteTecnicoDAOJPA() {
    super(SoporteTecnico.class);
  }

//  @Override
//  public List<SoporteTecnico> getAllData() throws ConnectionExcep {
//    try {
//      TypedQuery<SoporteTecnico> tq = em.createNamedQuery("SoporteTecnico.getAllData", classType);
//      return tq.getResultList();
//    } catch (Exception e) {
//      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
//    }
//  }
}
