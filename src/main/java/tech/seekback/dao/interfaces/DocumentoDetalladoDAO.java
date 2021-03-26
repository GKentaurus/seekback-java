
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.DocumentoDetallado;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface DocumentoDetalladoDAO extends DAO<DocumentoDetallado, Integer> {
  void delete(DocumentoDetallado documentoDetallado) throws ConnectionExcep;
}
