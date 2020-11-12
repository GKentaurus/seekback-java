/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.TipoDoc;

/**
 *
 * @author camorenoc
 */
public interface TipoDocDAO {

  /**
   * CRUD Definition
   */
  void create();

  TipoDoc getOne(Integer id);

  List<TipoDoc> getAll();

  void update(TipoDoc obj);

  void delete(TipoDoc obj);
}
