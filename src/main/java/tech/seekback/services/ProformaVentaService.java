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

  /**
   *
   * @param proformaVenta
   * @return Un objeto de tipo de tipo ProformaVenta
   * @throws ConnectionExcep
   */
  public ProformaVenta create(ProformaVenta proformaVenta) throws ConnectionExcep {
    return proformaVentaDAO.create(proformaVenta);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo de tipo ProformaVenta consultado por id
   * @throws ConnectionExcep
   */
  public ProformaVenta getOne(Integer id) throws ConnectionExcep {
    return proformaVentaDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo ProformaVenta (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<ProformaVenta> getAll() throws ConnectionExcep {
    List<ProformaVenta> proformasVentas = proformaVentaDAO.getAll();
    return proformasVentas;
  }

  /**
   * Actualiza un objeto de tipo ProformaVenta
   *
   * @param proformaVenta
   * @throws ConnectionExcep
   */
  public void update(ProformaVenta proformaVenta) throws ConnectionExcep {
    proformaVentaDAO.update(proformaVenta);
  }

  /**
   * Elimina un objeto de tipo ProformaVenta
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    proformaVentaDAO.delete(id);
  }
}
