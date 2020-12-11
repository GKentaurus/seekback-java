/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.ProformaVentaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.ProformaVenta;

/**
 *
 * @author camorenoc
 */
@Stateless
public class ProformaVentaService {

  @EJB
  private ProformaVentaDAO proformaVentaDAO;

  public ProformaVenta create(ProformaVenta proformaVenta) throws ConnectionExcep {
    return proformaVentaDAO.create(proformaVenta);
  }

  public ProformaVenta getOne(Integer id) throws ConnectionExcep {
    return proformaVentaDAO.getOne(id);
  }

  public List<ProformaVenta> getAll() throws ConnectionExcep {
    List<ProformaVenta> proformasVentas = proformaVentaDAO.getAll();
    return proformasVentas;
  }

  public void update(ProformaVenta proformaVenta) throws ConnectionExcep {
    proformaVentaDAO.update(proformaVenta);
  }

  public void delete(Integer id) throws ConnectionExcep {
    proformaVentaDAO.delete(id);
  }
}
