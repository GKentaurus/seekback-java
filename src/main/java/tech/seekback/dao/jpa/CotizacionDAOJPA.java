/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CotizacionDAO;
import tech.seekback.models.Cotizacion;

/**
 *
 * @author camorenoc
 */
public class CotizacionDAOJPA extends GenericDAO<Cotizacion, Integer> implements CotizacionDAO {

  public CotizacionDAOJPA() {
    super(Cotizacion.class);
  }
}
