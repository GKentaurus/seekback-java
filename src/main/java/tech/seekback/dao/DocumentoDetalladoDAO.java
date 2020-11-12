/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.DocumentoDetallado;

/**
 *
 * @author camorenoc
 */
public interface DocumentoDetalladoDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  DocumentoDetallado getOne(Integer id) throws ConnectionExcep;

  List<DocumentoDetallado> getAll() throws ConnectionExcep;

  void update(DocumentoDetallado obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
