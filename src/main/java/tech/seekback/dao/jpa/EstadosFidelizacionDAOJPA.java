/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.EstadosFidelizacionDAO;
import tech.seekback.models.EstadosFidelizacion;

/**
 *
 * @author camorenoc
 */
public class EstadosFidelizacionDAOJPA extends GenericDAO<EstadosFidelizacion, Integer> implements EstadosFidelizacionDAO {

  public EstadosFidelizacionDAOJPA() {
    super(EstadosFidelizacion.class);
  }
}
