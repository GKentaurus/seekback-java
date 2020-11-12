/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Usuario;

/**
 *
 * @author camorenoc
 */
public interface UsuarioDAO {

  /**
   * CRUD Definition
   */
  void create();

  Usuario getOne(Integer id);

  List<Usuario> getAll();

  void update(Usuario obj);

  void delete(Usuario obj);
}
