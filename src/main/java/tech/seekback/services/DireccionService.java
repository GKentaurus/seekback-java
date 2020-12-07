/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.DireccionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Direccion;

/**
 *
 * @author danny
 */
@Stateless
public class DireccionService {

  @EJB
  private DireccionDAO direccionesDAO;

  public void create(Direccion direciones) throws ConnectionExcep {
    direccionesDAO.create(direciones);
  }

  public Direccion getOne(Integer id) throws ConnectionExcep {
    return direccionesDAO.getOne(id);
  }

  public List<Direccion> getAll() throws ConnectionExcep {
    List<Direccion> direcciones = direccionesDAO.getAll();
    return direcciones;
  }

  public void update(Direccion direccion) throws ConnectionExcep {
    direccionesDAO.update(direccion);
  }

  public void delete(Integer id) throws ConnectionExcep {
    direccionesDAO.delete(id);
  }
}
