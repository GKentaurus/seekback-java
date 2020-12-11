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

  public DocumentoDetallado create(DocumentoDetallado documentoDetallado) throws ConnectionExcep {
    return documentoDetalladoDAO.create(documentoDetallado);
  }

  public DocumentoDetallado getOne(Integer id) throws ConnectionExcep {
    return documentoDetalladoDAO.getOne(id);
  }

  public List<DocumentoDetallado> getAll() throws ConnectionExcep {
    return documentoDetalladoDAO.getAll();
  }

  public void update(DocumentoDetallado documentoDetallado) throws ConnectionExcep {
    documentoDetalladoDAO.update(documentoDetallado);
  }

  public void delete(Integer id) throws ConnectionExcep {
    documentoDetalladoDAO.delete(id);
  }
}
