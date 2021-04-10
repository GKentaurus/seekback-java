
package tech.seekback.dao;

import tech.seekback.exceptions.ConnectionExcep;

import java.util.List;

/**
 * Se declaran los métodos del CRUD
 *
 * @param <T>
 * @param <PK>
 * @author gkentaurus
 */
public interface DAO<T, PK> {

  T create(T obj) throws ConnectionExcep;

  void create(List<T> objs) throws ConnectionExcep;

  T getOne(PK id) throws ConnectionExcep;

  List<T> getAll() throws ConnectionExcep;

  void update(T obj) throws ConnectionExcep;

  void delete (T obj) throws ConnectionExcep;
}
