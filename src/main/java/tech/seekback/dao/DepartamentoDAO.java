/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Departamento;

/**
 *
 * @author camorenoc
 */
public interface DepartamentoDAO {

  /**
   * CRUD Definition
   */
  void create();

  Departamento getOne(Integer id);

  List<Departamento> getAll();

  void update(Departamento obj);

  void delete(Departamento obj);
}
