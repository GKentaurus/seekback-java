/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.DocumentoDetalladoDAO;
import tech.seekback.models.DocumentoDetallado;

/**
 *
 * @author camorenoc
 */
@Stateless
public class DocumentoDetalladoDAOJPA extends GenericDAO<DocumentoDetallado, Integer> implements DocumentoDetalladoDAO {

  public DocumentoDetalladoDAOJPA() {
    super(DocumentoDetallado.class);
  }
}
