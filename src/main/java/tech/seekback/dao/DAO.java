/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;

/**
 * Se declaran los métodos del CRUD
 *
 * @author gkentaurus
 * @param <T>
 * @param <PK>
 */
public interface DAO<T, PK> {

  T create(T obj) throws ConnectionExcep;

  T getOne(PK id) throws ConnectionExcep;

  List<T> getAll() throws ConnectionExcep;

  void update(T obj) throws ConnectionExcep;
}