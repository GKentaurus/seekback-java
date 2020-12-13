/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.AdministradorDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Administrador;

/**
 *
 * @author camorenoc
 */
@Stateless
public class AdministradorDAOJPA extends GenericDAO<Administrador, Integer> implements AdministradorDAO {

  public AdministradorDAOJPA() {
    super(Administrador.class);
  }

  /**
   *
   * @param id del Usuario
   * @return Un objeto de tipo Administrador
   * @throws ConnectionExcep
   */
  @Override
  public Administrador getByIdUsuario(Integer id) throws ConnectionExcep {

    try {
      TypedQuery<Administrador> tq = em.createNamedQuery("Empleado.getByIdUsuario", classType);
      tq.setParameter("idUsuario", id);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
