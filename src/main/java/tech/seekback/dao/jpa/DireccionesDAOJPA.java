/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.DireccionesDAO;
import tech.seekback.models.Direcciones;

/**
 *
 * @author camorenoc
 */
public class DireccionesDAOJPA extends GenericDAO<Direcciones, Integer> implements DireccionesDAO {

  public DireccionesDAOJPA() {
    super(Direcciones.class);
  }
}
