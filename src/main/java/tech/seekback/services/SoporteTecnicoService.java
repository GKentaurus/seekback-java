/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.SoporteTecnicoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.SoporteTecnico;

/**
 *
 * @author camorenoc
 */
@Stateless
public class SoporteTecnicoService {

  @EJB
  private SoporteTecnicoDAO soporteTecnicoDAO;

  public SoporteTecnico create(SoporteTecnico soporteTecnico) throws ConnectionExcep {
    return soporteTecnicoDAO.create(soporteTecnico);
  }

  public SoporteTecnico getOne(Integer id) throws ConnectionExcep {
    return soporteTecnicoDAO.getOne(id);
  }

  public List<SoporteTecnico> getAll() throws ConnectionExcep {
    List<SoporteTecnico> seportesTecnicos = soporteTecnicoDAO.getAll();
    return seportesTecnicos;
  }

  public void update(SoporteTecnico soporteTecnico) throws ConnectionExcep {
    soporteTecnicoDAO.update(soporteTecnico);
  }

  public void delete(Integer id) throws ConnectionExcep {
    soporteTecnicoDAO.delete(id);
  }
}
