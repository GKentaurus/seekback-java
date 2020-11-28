/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tech.seekback.dao.interfaces.DepartamentoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Departamento;

/**
 *
 * @author danny
 */
@Stateless
public class DepartamentoService {

  @EJB
  private DepartamentoDAO departamentoDAO;

  public List<Departamento> getByIdPais(Integer idPais) throws ConnectionExcep {
    List<Departamento> departamentos = departamentoDAO.getByIdPais(idPais);
    return departamentos;
  }

}
