/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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

  public List<Ciudad> getByIdDepartamento(Integer idDepartamento) throws ConnectionExcep {
    System.out.println("pues eso " + idDepartamento);
    List<Ciudad> ciudades = ciudadDAO.getByIdDepartamento(idDepartamento);
    return ciudades;
  }

}
