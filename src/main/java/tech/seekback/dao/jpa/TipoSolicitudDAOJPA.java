/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TipoSolicitudDAO;
import tech.seekback.models.TipoSolicitud;

/**
 *
 * @author camorenoc
 */
@Stateless
public class TipoSolicitudDAOJPA extends GenericDAO<TipoSolicitud, Integer> implements TipoSolicitudDAO {

  public TipoSolicitudDAOJPA() {
    super(TipoSolicitud.class);
  }
}
