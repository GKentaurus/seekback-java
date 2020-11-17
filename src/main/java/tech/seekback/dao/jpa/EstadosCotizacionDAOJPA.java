/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.EstadosCotizacionDAO;
import tech.seekback.models.EstadosCotizacion;

/**
 *
 * @author camorenoc
 */
public class EstadosCotizacionDAOJPA extends GenericDAO<EstadosCotizacion, Integer> implements EstadosCotizacionDAO {

  public EstadosCotizacionDAOJPA() {
    super(EstadosCotizacion.class);
  }
}
