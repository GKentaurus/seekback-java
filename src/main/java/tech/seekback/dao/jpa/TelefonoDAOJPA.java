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
import tech.seekback.models.Telefono;
import tech.seekback.dao.interfaces.TelefonoDAO;

/**
 *
 * @author camorenoc
 */
@Stateless
public class TelefonoDAOJPA extends GenericDAO<Telefono, Integer> implements TelefonoDAO {

  public TelefonoDAOJPA() {
    super(Telefono.class);
  }

  @Override
  public Telefono getByIdUsuario(Integer IdUsuario) throws ConnectionExcep {

    try {
      TypedQuery<Telefono> tq = em.createNamedQuery("Telefonos.getByIdUsuario", classType);
      tq.setParameter("idUsuario", IdUsuario);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }

  }

}
