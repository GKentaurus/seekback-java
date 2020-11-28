/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tech.seekback.dao.interfaces.DireccionesDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Direcciones;

/**
 *
 * @author danny
 */
@Stateless
public class DireccionesService {

  @EJB
  private DireccionesDAO direccionesDAO;

  public void create(Direcciones direciones) throws ConnectionExcep {
    direccionesDAO.create(direciones);
  }

  public Direcciones getOne(Integer id) throws ConnectionExcep {
    return direccionesDAO.getOne(id);
  }

  public List<Direcciones> getAll() throws ConnectionExcep {
    List<Direcciones> direcciones = direccionesDAO.getAll();
    return direcciones;
  }
}
