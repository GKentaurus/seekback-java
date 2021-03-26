
package tech.seekback.services;

import tech.seekback.dao.interfaces.ProformaVentaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.ProformaVenta;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class ProformaVentaService {

  @EJB
  private ProformaVentaDAO proformaVentaDAO;

  /**
   * @param proformaVenta
   * @return Un objeto de tipo de tipo ProformaVenta
   * @throws ConnectionExcep
   */
  public ProformaVenta create(ProformaVenta proformaVenta) throws ConnectionExcep {
    return proformaVentaDAO.create(proformaVenta);
  }

  /**
   * @param id
   * @return Un objeto de tipo de tipo ProformaVenta consultado por id
   * @throws ConnectionExcep
   */
  public ProformaVenta getOne(Integer id) throws ConnectionExcep {
    return proformaVentaDAO.getOne(id);
  }

  /**
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
   * @param proformaVenta
   * @throws ConnectionExcep
   */
  public void delete(ProformaVenta proformaVenta) throws ConnectionExcep {
    proformaVentaDAO.delete(proformaVenta);
  }
}
