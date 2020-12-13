/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ClienteDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.models.Cliente;

/**
 *
 * @author camorenoc
 */
@Stateless
public class ClienteDAOJPA extends GenericDAO<Cliente, Integer> implements ClienteDAO {

  public ClienteDAOJPA() {
    super(Cliente.class);
  }

  /**
   *
   * @param id del Usuario
   * @return Un objeto de tipo Cliente
   * @throws ConnectionExcep
   */
  @Override
  public Cliente getByIdUsuario(Integer id) throws ConnectionExcep {

    try {
      TypedQuery<Cliente> tq = em.createNamedQuery("Cliente.getByIdUsuario", classType);
      tq.setParameter("idUsuario", id);
      return tq.getSingleResult();
    } catch (Exception e) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION, e);
    }
  }
}
