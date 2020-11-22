/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CalificacionDAO;
import tech.seekback.models.Calificacion;

/**
 *
 * @author camorenoc
 */
@Stateless
public class CalificacionDAOJPA extends GenericDAO<Calificacion, Integer> implements CalificacionDAO {

  public CalificacionDAOJPA() {
    super(Calificacion.class);
  }
}
