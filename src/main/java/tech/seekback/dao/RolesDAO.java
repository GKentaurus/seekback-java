/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Roles;

/**
 *
 * @author camorenoc
 */
public interface RolesDAO {

  /**
   * CRUD Definition
   */
  void create();

  Roles getOne(Integer id);

  List<Roles> getAll();

  void update(Roles obj);

  void delete(Roles obj);
}
