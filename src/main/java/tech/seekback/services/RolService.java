/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import tech.seekback.dao.interfaces.RolDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Rol;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author camorenoc
 */
@Stateless
public class RolService {

  @EJB
  private RolDAO rolesDAO;

  /**
   * @param rol
   * @return Un objeto de tipo Rol
   * @throws ConnectionExcep
   */
  public Rol create(Rol rol) throws ConnectionExcep {
    return rolesDAO.create(rol);
  }

  /**
   * @param id
   * @return Un objeto de tipo Rol consultado por id
   * @throws ConnectionExcep
   */
  public Rol getOne(Integer id) throws ConnectionExcep {
    return rolesDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Rol (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Rol> getAll() throws ConnectionExcep {
    List<Rol> roles = rolesDAO.getAll();
    return roles;
  }

  /**
   * Actualiza un objeto de tipo Rol
   *
   * @param rol
   * @throws ConnectionExcep
   */
  public void update(Rol rol) throws ConnectionExcep {
    rolesDAO.update(rol);
  }

  /**
   * Elimina un objeto de tipo Rol
   *
   * @param rol
   * @throws ConnectionExcep
   */
  public void delete(Rol rol) throws ConnectionExcep {
    rolesDAO.delete(rol);
  }
}