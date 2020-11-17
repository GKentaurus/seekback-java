/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ProformaVentaDAO;
import tech.seekback.models.ProformaVenta;

/**
 *
 * @author camorenoc
 */
public class ProformaVentaDAOJPA extends GenericDAO<ProformaVenta, Integer> implements ProformaVentaDAO {

  public ProformaVentaDAOJPA() {
    super(ProformaVenta.class);
  }
}
