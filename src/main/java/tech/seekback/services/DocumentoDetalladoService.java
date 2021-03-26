
package tech.seekback.services;

import tech.seekback.dao.interfaces.DocumentoDetalladoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.DocumentoDetallado;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class DocumentoDetalladoService {

  @EJB

  private DocumentoDetalladoDAO documentoDetalladoDAO;

  /**
   * @param documentoDetallado
   * @return Un objeto de tipo DocumentoDetallado
   * @throws ConnectionExcep
   */
  public DocumentoDetallado create(DocumentoDetallado documentoDetallado) throws ConnectionExcep {
    return documentoDetalladoDAO.create(documentoDetallado);
  }

  /**
   * @param id
   * @return Un objeto de tipo DocumentoDetallado consultado por id
   * @throws ConnectionExcep
   */
  public DocumentoDetallado getOne(Integer id) throws ConnectionExcep {
    return documentoDetalladoDAO.getOne(id);
  }

  /**
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
   * @param documentoDetallado
   * @throws ConnectionExcep
   */
  public void delete(DocumentoDetallado documentoDetallado) throws ConnectionExcep {
    documentoDetalladoDAO.delete(documentoDetallado);
  }
}
