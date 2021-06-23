package tech.seekback.services;

import tech.seekback.dao.interfaces.CategoriasProductoDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.CategoriasProducto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class CategoriasProductoService {

  @EJB
  private CategoriasProductoDAO categoriasProductoDAO;

  private final String column = "nombreCategoria";

  /**
   * @param categoriasProducto
   * @return Un objeto de tipo CategoriasProducto
   * @throws ConnectionExcep
   */
  public CategoriasProducto create(CategoriasProducto categoriasProducto) throws ConnectionExcep {
    if (this.categoriasProductoDAO.checkIfExist(categoriasProducto, column, categoriasProducto.getNombreCategoria())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return this.categoriasProductoDAO.create(categoriasProducto);
  }

  public List<CategoriasProducto> create(List<CategoriasProducto> listaCategoriasProductos) throws ConnectionExcep {
    List<CategoriasProducto> errors = new ArrayList<>();
    for (CategoriasProducto categoriasProducto : listaCategoriasProductos) {
      if (!this.categoriasProductoDAO.checkIfExist(categoriasProducto, column, categoriasProducto.getNombreCategoria())) {
        this.categoriasProductoDAO.create(categoriasProducto);
      } else {
        errors.add(categoriasProducto);
      }
    }
    return errors;
  }

  /**
   * @param id
   * @return Un objeto de tipo CategoriasProducto consultado por el id
   * @throws ConnectionExcep
   */
  public CategoriasProducto getOne(Integer id) throws ConnectionExcep {
    return categoriasProductoDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo CategoriasProducto (referente al
   * Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<CategoriasProducto> getAll() throws ConnectionExcep {
    List<CategoriasProducto> categorias = categoriasProductoDAO.getAll();
    return categorias;
  }

  /**
   * Actualiza un objeto de tipo CategoriasProducto
   *
   * @param categoriasProducto
   * @throws ConnectionExcep
   */
  public void update(CategoriasProducto categoriasProducto) throws ConnectionExcep {
    categoriasProductoDAO.update(categoriasProducto);
  }

  /**
   * Elimina un objeto de tipo CategoriasProducto
   *
   * @param categoriasProducto
   * @throws ConnectionExcep
   */
  public void delete(CategoriasProducto categoriasProducto) throws ConnectionExcep {
    categoriasProductoDAO.delete(categoriasProducto);
  }
}
