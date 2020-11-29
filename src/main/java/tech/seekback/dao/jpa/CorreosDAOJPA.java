/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CorreosDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Correos;

/**
 *
 * @author camorenoc
 */
@Stateless
public class CorreosDAOJPA extends GenericDAO<Correos, Integer> implements CorreosDAO {

  public CorreosDAOJPA() {
    super(Correos.class);
  }

  @Override
  public Correos getByCorreo(String email) throws ConnectionExcep {

    try {
      TypedQuery<Correos> tq = em.createNamedQuery("Correos.getByCorreo", classType);
      tq.setParameter("CorreoRec", email);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }

  }

}
