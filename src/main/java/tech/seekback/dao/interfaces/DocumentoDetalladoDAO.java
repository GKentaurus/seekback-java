/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.interfaces;

import javax.ejb.Remote;
import tech.seekback.dao.DAO;
import tech.seekback.models.DocumentoDetallado;

/**
 *
 * @author camorenoc
 */
@Remote
public interface DocumentoDetalladoDAO extends DAO<DocumentoDetallado, Integer> {
}