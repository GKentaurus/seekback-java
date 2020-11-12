/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Fidelizacion;

/**
 *
 * @author camorenoc
 */
public interface FidelizacionDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Fidelizacion getOne(Integer id) throws ConnectionExcep;

  List<Fidelizacion> getAll() throws ConnectionExcep;

  void update(Fidelizacion obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
