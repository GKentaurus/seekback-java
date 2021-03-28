
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.DocumentoDetalladoDAO;
import tech.seekback.models.DocumentoDetallado;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class DocumentoDetalladoDAOJPA extends GenericDAO<DocumentoDetallado, Integer> implements DocumentoDetalladoDAO {

  public DocumentoDetalladoDAOJPA() {
    super(DocumentoDetallado.class);
  }
}
