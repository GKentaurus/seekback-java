/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoDoc;

/**
 *
 * @author camorenoc
 */
public interface TipoDocDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  TipoDoc getOne(Integer id) throws ConnectionExcep;

  List<TipoDoc> getAll() throws ConnectionExcep;

  void update(TipoDoc obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
