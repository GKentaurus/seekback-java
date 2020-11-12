/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Calificacion;

/**
 *
 * @author camorenoc
 */
public interface CalificacionDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Calificacion getOne(Integer id) throws ConnectionExcep;

  List<Calificacion> getAll() throws ConnectionExcep;

  void update(Calificacion obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
