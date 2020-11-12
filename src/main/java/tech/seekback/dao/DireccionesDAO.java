/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Direcciones;

/**
 *
 * @author camorenoc
 */
public interface DireccionesDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Direcciones getOne(Integer id) throws ConnectionExcep;

  List<Direcciones> getAll() throws ConnectionExcep;

  void update(Direcciones obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
