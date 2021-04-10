package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.BodegaProducto;

import javax.ejb.Local;
import java.util.List;

/**
 * @author gkentaurus
 */
@Local
public interface BodegaProductoDAO extends DAO<BodegaProducto, Integer> {

  List<BodegaProducto> getByIdCategoria(int idCategoria) throws ConnectionExcep;

  List<BodegaProducto> getLikeName(String parteNombre) throws ConnectionExcep;

  BodegaProducto getByIdProducto(Integer idProducto) throws ConnectionExcep;
}
