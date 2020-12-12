/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.TelefonoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Telefono;

/**
 *
 * @author camorenoc
 */
@Stateless
public class TelefonoService {

  @EJB
  private TelefonoDAO telefonoDAO;

  /**
   *
   * @param telefono
   * @return Un objeto de tipo Telefono
   * @throws ConnectionExcep
   */
  public Telefono create(Telefono telefono) throws ConnectionExcep {
    return telefonoDAO.create(telefono);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo Telefono consultado por id
   * @throws ConnectionExcep
   */
  public Telefono getOne(Integer id) throws ConnectionExcep {
    return telefonoDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo Telefono (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<Telefono> getAll() throws ConnectionExcep {
    List<Telefono> telefonos = telefonoDAO.getAll();
    return telefonos;
  }

  /**
   *
   * @param IdUsuario
   * @return Una colección de objetos de tipo Telefono consultados por IdUsuario
   * @throws ConnectionExcep
   */
  public Telefono getByIdUsuario(Integer IdUsuario) throws ConnectionExcep {
    return telefonoDAO.getByIdUsuario(IdUsuario);
  }

  /**
   *
   * @param IdUsuario
   * @return Una colección de objetos de tipo Telefono consultados por IdUsuario
   * @throws ConnectionExcep
   */
  public Telefono getByIdPrincipal(Integer IdUsuario) throws ConnectionExcep {
    return telefonoDAO.getByIdUsuario(IdUsuario);
  }

  /**
   * Actualiza un objeto de tipo Telefono
   *
   * @param telefono
   * @throws ConnectionExcep
   */
  public void update(Telefono telefono) throws ConnectionExcep {
    telefonoDAO.update(telefono);
  }

  /**
   * Elimina un objeto de tipo Telefono
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    telefonoDAO.delete(id);
  }

}
