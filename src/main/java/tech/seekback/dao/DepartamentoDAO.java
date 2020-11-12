/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Departamento;

/**
 *
 * @author camorenoc
 */
public interface DepartamentoDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Departamento getOne(Integer id) throws ConnectionExcep;

  List<Departamento> getAll() throws ConnectionExcep;

  void update(Departamento obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
