/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.CiudadDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Ciudad;

/**
 *
 * @author danny
 */
@Stateless
public class CiudadService {

  @EJB
  private CiudadDAO ciudadDAO;

  public void create(Ciudad ciudad) throws ConnectionExcep {
    ciudadDAO.create(ciudad);
  }

  public Ciudad getOne(Integer id) throws ConnectionExcep {
    return ciudadDAO.getOne(id);
  }

  public List<Ciudad> getByIdDepartamento(Integer idDepartamento) throws ConnectionExcep {
    System.out.println("pues eso " + idDepartamento);
    List<Ciudad> ciudades = ciudadDAO.getByIdDepartamento(idDepartamento);
    return ciudades;
  }

  public void update(Ciudad ciudad) throws ConnectionExcep {
    ciudadDAO.update(ciudad);
  }

  public void delete(Integer id) throws ConnectionExcep {
    ciudadDAO.delete(id);
  }
}
