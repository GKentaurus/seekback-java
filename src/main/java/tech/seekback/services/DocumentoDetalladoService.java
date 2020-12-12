/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.DocumentoDetalladoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.DocumentoDetallado;

/**
 *
 * @author camorenoc
 */
@Stateless
public class DocumentoDetalladoService {

  @EJB

  private DocumentoDetalladoDAO documentoDetalladoDAO;

  /**
   *
   * @param documentoDetallado
   * @return Un objeto de tipo DocumentoDetallado
   * @throws ConnectionExcep
   */
  public DocumentoDetallado create(DocumentoDetallado documentoDetallado) throws ConnectionExcep {
    return documentoDetalladoDAO.create(documentoDetallado);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo DocumentoDetallado consultado por id
   * @throws ConnectionExcep
   */
  public DocumentoDetallado getOne(Integer id) throws ConnectionExcep {
    return documentoDetalladoDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo DocumentoDetallado (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<DocumentoDetallado> getAll() throws ConnectionExcep {
    return documentoDetalladoDAO.getAll();
  }

  /**
   * Actualiza un objeto de tipo DocumentoDetallado
   *
   * @param documentoDetallado
   * @throws ConnectionExcep
   */
  public void update(DocumentoDetallado documentoDetallado) throws ConnectionExcep {
    documentoDetalladoDAO.update(documentoDetallado);
  }

  /**
   * Elimina un objeto de tipo DocumentoDetallado
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    documentoDetalladoDAO.delete(id);
  }
}
