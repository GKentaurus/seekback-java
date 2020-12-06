/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Direccion;
import tech.seekback.dao.interfaces.DireccionDAO;

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
}
