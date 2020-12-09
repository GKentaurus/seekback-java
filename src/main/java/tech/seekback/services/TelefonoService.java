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

  public void create(Telefono telefono) throws ConnectionExcep {
    telefonoDAO.create(telefono);
  }

  public Telefono getOne(Integer id) throws ConnectionExcep {
    return telefonoDAO.getOne(id);
  }

  public List<Telefono> getAll() throws ConnectionExcep {
    List<Telefono> telefonos = telefonoDAO.getAll();
    return telefonos;
  }

  public Telefono getByIdUsuario(Integer IdUsuario) throws ConnectionExcep {
    return telefonoDAO.getByIdUsuario(IdUsuario);
  }

  public void update(Telefono telefono) throws ConnectionExcep {
    telefonoDAO.update(telefono);
  }

  public void delete(Integer id) throws ConnectionExcep {
    telefonoDAO.delete(id);
  }

}
