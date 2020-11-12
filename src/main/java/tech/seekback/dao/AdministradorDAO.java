/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Administrador;

/**
 *
 * @author camorenoc
 */
public interface AdministradorDAO {

  /**
   * CRUD Definition
   */
  void create();

  Administrador getOne(Integer id);

  List<Administrador> getAll();

  void update(Administrador obj);

  void delete(Administrador obj);
}
