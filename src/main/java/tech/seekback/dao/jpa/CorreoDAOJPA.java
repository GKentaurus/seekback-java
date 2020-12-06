/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import tech.seekback.dao.GenericDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Correo;
import tech.seekback.dao.interfaces.CorreoDAO;

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
      TypedQuery<Correo> tq = em.createNamedQuery("Correos.getByCorreo", classType);
      tq.setParameter("CorreoRec", email);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }

  }

}
