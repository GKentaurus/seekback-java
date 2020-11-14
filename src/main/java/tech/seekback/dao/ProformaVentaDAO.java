/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.ProformaVenta;

/**
 *
 * @author camorenoc
 */
public interface ProformaVentaDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  ProformaVenta getOne(Integer id) throws ConnectionExcep;

  List<ProformaVenta> getAll() throws ConnectionExcep;

  void update(ProformaVenta obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}