/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoServicio;

/**
 *
 * @author camorenoc
 */
public interface TipoServicioDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  TipoServicio getOne(Integer id) throws ConnectionExcep;

  List<TipoServicio> getAll() throws ConnectionExcep;

  void update(TipoServicio obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
