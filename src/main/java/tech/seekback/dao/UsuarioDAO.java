/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

/**
 *
 * @author camorenoc
 */
public interface UsuarioDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Usuario getOne(Integer id) throws ConnectionExcep;

  List<Usuario> getAll() throws ConnectionExcep;

  void update(Usuario obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
