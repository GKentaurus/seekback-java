/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.EmpleadoDAO;
import tech.seekback.models.Empleado;

/**
 *
 * @author camorenoc
 */
public class EmpleadoDAOJPA extends GenericDAO<Empleado, Integer> implements EmpleadoDAO {

  public EmpleadoDAOJPA() {
    super(Empleado.class);
  }
}
