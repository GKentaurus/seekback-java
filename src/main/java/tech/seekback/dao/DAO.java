
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;

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

  boolean checkIfExist(T obj, String column, String value) throws ConnectionExcep;

  T getOne(PK id) throws ConnectionExcep;

  List<T> getAll() throws ConnectionExcep;

  void update(T obj) throws ConnectionExcep;

  void delete (T obj) throws ConnectionExcep;
}
