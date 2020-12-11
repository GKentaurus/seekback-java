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

  public Departamento create(Departamento departamento) throws ConnectionExcep {
    return departamentoDAO.create(departamento);
  }

  public Departamento getOne(Integer id) throws ConnectionExcep {
    return departamentoDAO.getOne(id);
  }

  public List<Departamento> getAll() throws ConnectionExcep {
    List<Departamento> departamentos = departamentoDAO.getAll();
    return departamentos;
  }

  public List<Departamento> getByIdPais(Integer idPais) throws ConnectionExcep {
    List<Departamento> departamentos = departamentoDAO.getByIdPais(idPais);
    return departamentos;
  }

  public void update(Departamento departamento) throws ConnectionExcep {
    departamentoDAO.update(departamento);
  }

  public void delete(Integer id) throws ConnectionExcep {
    departamentoDAO.delete(id);
  }
}
