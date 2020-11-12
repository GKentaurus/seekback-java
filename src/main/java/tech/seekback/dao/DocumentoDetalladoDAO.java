/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.DocumentoDetallado;

/**
 *
 * @author camorenoc
 */
public interface DocumentoDetalladoDAO {

  /**
   * CRUD Definition
   */
  void create();

  DocumentoDetallado getOne(Integer id);

  List<DocumentoDetallado> getAll();

  void update(DocumentoDetallado obj);

  void delete(DocumentoDetallado obj);
}
