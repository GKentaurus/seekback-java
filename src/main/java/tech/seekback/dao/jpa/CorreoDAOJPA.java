/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CorreoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Correo;

/**
 *
 * @author camorenoc
 */
@Stateless
public class CorreoDAOJPA extends GenericDAO<Correo, Integer> implements CorreoDAO {

  public CorreoDAOJPA() {
    super(Correo.class);
  }

  @Override
  public Correo getByCorreo(String email) throws ConnectionExcep {
    try {
      TypedQuery<Correo> tq = em.createNamedQuery("Correo.getByCorreo", classType);
      tq.setParameter("CorreoRec", email);
      try {
        Correo correo = tq.getSingleResult();
        return correo;
      } catch (NoResultException ex) {
        return null;
      }

    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }

  }

}
