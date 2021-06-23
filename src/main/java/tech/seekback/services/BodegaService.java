package tech.seekback.services;

import tech.seekback.dao.interfaces.BodegaDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Bodega;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class BodegaService {

  @EJB
  private BodegaDAO bodegaDAO;

  private final String column = "nombreBodega";

  /**
   * @param bodega
   * @return Un objeto de tipo Bodega
   * @throws ConnectionExcep
   */
  public Bodega create(Bodega bodega) throws ConnectionExcep {
    if (this.bodegaDAO.checkIfExist(bodega, column, bodega.getNombreBodega())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return this.bodegaDAO.create(bodega);
  }

  public List<Bodega> create(List<Bodega> listaBodegas) throws ConnectionExcep {
    List<Bodega> errors = new ArrayList<>();
    for (Bodega bodega : listaBodegas) {
      if (!this.bodegaDAO.checkIfExist(bodega, column, bodega.getNombreBodega())) {
        this.bodegaDAO.create(bodega);
      } else {
        errors.add(bodega);
      }
    }
    return errors;
  }

  /**
   * @param id
   * @return Un objeto de tipo Bodega consultado por el id
   * @throws ConnectionExcep
   */
  public Bodega getOne(Integer id) throws ConnectionExcep {
    return bodegaDAO.getOne(id);
  }

  /**
   * @return Una coleccion de objetos de tipo Bodega (referente al DAO que lo
   * implemente)
   * @throws ConnectionExcep
   */
  public List<Bodega> getAll() throws ConnectionExcep {
    List<Bodega> bodegas = bodegaDAO.getAll();
    return bodegas;
  }

  /**
   * Actualiza un objeto tipo Bodega
   *
   * @param bodega
   * @throws ConnectionExcep
   */
  public void update(Bodega bodega) throws ConnectionExcep {
    bodegaDAO.update(bodega);
  }

  /**
   * Elimina un objeto de tipo Bodega
   *
   * @param bodega
   * @throws ConnectionExcep
   */
  public void delete(Bodega bodega) throws ConnectionExcep {
    bodegaDAO.delete(bodega);
  }
}
