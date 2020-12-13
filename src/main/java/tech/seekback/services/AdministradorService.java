/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.AdministradorDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Administrador;

/**
 *
 * @author camorenoc
 */
@Stateless
public class AdministradorService {

  @EJB

  private AdministradorDAO administradorDAO;

  /**
   *
   * @param administrador
   * @return Retorna un objeto de tipo Administrador
   * @throws ConnectionExcep
   */
  public Administrador create(Administrador administrador) throws ConnectionExcep {
    return administradorDAO.create(administrador);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo Administrador consultado por el id
   * @throws ConnectionExcep
   */
  public Administrador getOne(Integer id) throws ConnectionExcep {
    return administradorDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo Administrador (referente al DAO que lo implemente)
   * @throws ConnectionExcep
   */
  public List<Administrador> getAll() throws ConnectionExcep {
    return administradorDAO.getAll();
  }

  /**
   *
   * @param id del Usuario
   * @return Un objeto de tipo Administrador
   * @throws ConnectionExcep
   */
  public Administrador getByIdUsuario(Integer id) throws ConnectionExcep {
    return administradorDAO.getByIdUsuario(id);
  }

  /**
   * Actualiza un objeto de tipo Administrador
   *
   * @param administrador
   * @throws ConnectionExcep
   */
  public void update(Administrador administrador) throws ConnectionExcep {
    administradorDAO.update(administrador);
  }

  /**
   * Elimina un objeto de tipo Administrador consultado por el id
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    administradorDAO.delete(id);
  }
}
