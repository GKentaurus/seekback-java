
package tech.seekback.services;

import tech.seekback.dao.interfaces.ProveedorDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Proveedor;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class ProveedorService {

  @EJB
  private ProveedorDAO proveedorDAO;

  private final String column = "numeroDoc";

  /**
   * @param proveedor
   * @return Un objeto de tipo de tipo Proveedor
   * @throws ConnectionExcep
   */
  public Proveedor create(Proveedor proveedor) throws ConnectionExcep {
    if (this.proveedorDAO.checkIfExist(proveedor, column, proveedor.getNumeroDoc())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return this.proveedorDAO.create(proveedor);
  }

  public List<Proveedor> create(List<Proveedor> listaProveedors) throws ConnectionExcep {
    List<Proveedor> errors = new ArrayList<>();
    for (Proveedor proveedor : listaProveedors) {
      if (!this.proveedorDAO.checkIfExist(proveedor, column, proveedor.getNumeroDoc())) {
        this.proveedorDAO.create(proveedor);
      } else {
        errors.add(proveedor);
      }
    }
    return errors;
  }

  /**
   * @param id
   * @return Un objeto de tipo de tipo Proveedor consultado por id
   * @throws ConnectionExcep
   */
  public Proveedor getOne(Integer id) throws ConnectionExcep {
    return proveedorDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Proveedor (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Proveedor> getAll() throws ConnectionExcep {
    List<Proveedor> proveedores = proveedorDAO.getAll();
    return proveedores;
  }

  /**
   * Actualiza un objeto de tipo Proveedor
   *
   * @param proveedor
   * @throws ConnectionExcep
   */
  public void update(Proveedor proveedor) throws ConnectionExcep {
    proveedorDAO.update(proveedor);
  }

  /**
   * Elimina un objeto de tipo Proveedor
   *
   * @param proveedor
   * @throws ConnectionExcep
   */
  public void delete(Proveedor proveedor) throws ConnectionExcep {
    proveedorDAO.delete(proveedor);
  }
}
