/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tech.seekback.dao.interfaces.CorreosDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correos;

/**
 *
 * @author danny
 */
@Stateless
public class CorreosService {

  @EJB
  private CorreosDAO correosDAO;

  public void create(Correos correos) throws ConnectionExcep {
    correosDAO.create(correos);
  }

  public Correos getOne(Integer id) throws ConnectionExcep {
    return correosDAO.getOne(id);
  }

  public List<Correos> getAll() throws ConnectionExcep {
    List<Correos> correos = correosDAO.getAll();
    return correos;
  }

  public Correos getByCorreo(String Correo) throws ConnectionExcep {
    return correosDAO.getByCorreo(Correo);
  }

}
