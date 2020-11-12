/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Empleado;

/**
 *
 * @author camorenoc
 */
public interface EmpleadoDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Empleado getOne(Integer id) throws ConnectionExcep;

  List<Empleado> getAll() throws ConnectionExcep;

  void update(Empleado obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
