/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TipoServicioDAO;
import tech.seekback.models.TipoServicio;

/**
 *
 * @author camorenoc
 */
@Stateless
public class TipoServicioDAOJPA extends GenericDAO<TipoServicio, Integer> implements TipoServicioDAO {

  public TipoServicioDAOJPA() {
    super(TipoServicio.class);
  }
}
