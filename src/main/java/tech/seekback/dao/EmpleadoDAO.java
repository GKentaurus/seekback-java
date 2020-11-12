/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Empleado;

/**
 *
 * @author camorenoc
 */
public interface EmpleadoDAO {

  /**
   * CRUD Definition
   */
  void create();

  Empleado getOne(Integer id);

  List<Empleado> getAll();

  void update(Empleado obj);

  void delete(Empleado obj);
}
