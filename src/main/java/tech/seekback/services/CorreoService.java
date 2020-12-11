/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.CorreoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correo;

/**
 *
 * @author danny
 */
@Stateless
public class CorreoService {

  @EJB
  private CorreoDAO correosDAO;

  public Correo create(Correo correos) throws ConnectionExcep {
    return correosDAO.create(correos);
  }

  public Correo getOne(Integer id) throws ConnectionExcep {
    return correosDAO.getOne(id);
  }

  public List<Correo> getAll() throws ConnectionExcep {
    List<Correo> correos = correosDAO.getAll();
    return correos;
  }

  public Correo getByCorreo(String correo) throws ConnectionExcep {
    return correosDAO.getByCorreo(correo);
  }

  public void update(Correo correo) throws ConnectionExcep {
    correosDAO.update(correo);
  }

  public void delete(Integer id) throws ConnectionExcep {
    correosDAO.delete(id);
  }
}
