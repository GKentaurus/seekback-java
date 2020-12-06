/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.TipoServicioDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoServicio;

/**
 *
 * @author camorenoc
 */
@Stateless
public class TipoServicioService {

  @EJB
  private TipoServicioDAO tipoServicioDAO;

  public void create(TipoServicio tipoServicio) throws ConnectionExcep {
    tipoServicioDAO.create(tipoServicio);
  }

  public TipoServicio getOne(Integer id) throws ConnectionExcep {
    return tipoServicioDAO.getOne(id);
  }

  public List<TipoServicio> getAll() throws ConnectionExcep {
    List<TipoServicio> tipoServicios = tipoServicioDAO.getAll();
    return tipoServicios;
  }

}
