/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.SoporteTecnico;
// FIXME: Crear modelo SoporteTecnico

/**
 *
 * @author camorenoc
 */
public interface SoporteTecnicoDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  SoporteTecnico getOne(Integer id) throws ConnectionExcep;

  List<SoporteTecnico> getAll() throws ConnectionExcep;

  void update(SoporteTecnico obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
