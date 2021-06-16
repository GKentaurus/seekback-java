package tech.seekback.services;

import tech.seekback.dao.interfaces.CategoriasProductoDAO;
import tech.seekback.dao.interfaces.ProductoDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Producto;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.tools.BulkLoaderService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author gkentaurus
 */
@Stateless
public class ProductoService extends BulkLoaderService<Producto, Integer> {

  @EJB
  private ProductoDAO productoDAO;

  @EJB
  private CategoriasProductoDAO categoriasProductoDAO;

  private final String column = "modeloProducto";

  @PostConstruct
  public void init() {
    super.setDAO(productoDAO);
  }

  //<editor-fold desc="CRUD methods" defaultstate="collapsed">
  /**
   * @param producto
   * @return Un objeto de tipo de tipo Producto
   * @throws ConnectionExcep
   */
  public Producto create(Producto producto) throws ConnectionExcep {
    if (this.productoDAO.checkIfExist(producto, column, producto.getModeloProducto())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return this.productoDAO.create(producto);
  }

  /**
   * @param parteNombre
   * @return Una colección de objetos de tipo producto consultado por nombre
   * @throws ConnectionExcep
   */
  public List<Producto> getLikeName(String parteNombre) throws ConnectionExcep {
    List<Producto> productos = productoDAO.getLikeName(parteNombre);
    return productos;
  }

  public List<Producto> create(List<Producto> listaProductos) throws ConnectionExcep {
    List<Producto> errors = new ArrayList<>();
    for (Producto producto : listaProductos) {
      if (!this.productoDAO.checkIfExist(producto, column, producto.getModeloProducto())) {
        this.productoDAO.create(producto);
      } else {
        errors.add(producto);
      }
    }
    return errors;
  }

  /**
   * @param id
   * @return Un objeto de tipo de tipo Producto consultado por id
   * @throws ConnectionExcep
   */
  public Producto getOne(Integer id) throws ConnectionExcep {
    return productoDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Producto (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<Producto> getAll() throws ConnectionExcep {
    return productoDAO.getAll();
  }

  public Integer getCategoryCount(Integer id) throws ConnectionExcep {
    return productoDAO.getCatCount(id);
  }

  public List<Producto> getCategoryProducts(Integer idCategory) throws ConnectionExcep {
    return productoDAO.getCategoryProducts(idCategory);
  }

  public List<Producto> getLastProducts(Integer limit) throws ConnectionExcep {
    return productoDAO.getLastProducts(limit);
  }

  /**
   * Actualiza un objeto de tipo Producto
   *
   * @param producto
   * @throws ConnectionExcep
   */
  public void update(Producto producto) throws ConnectionExcep {
    productoDAO.update(producto);
  }

  /**
   * Elimina un objeto de tipo Producto
   *
   * @param producto
   * @throws ConnectionExcep
   */
  public void delete(Producto producto) throws ConnectionExcep {
    productoDAO.delete(producto);
  }
  //</editor-fold>

  //<editor-fold desc="Bulk Load" defaultstate="collapsed">
  protected Producto objectMaker(String line, Integer modelFieldsCount) throws ConnectionExcep, NumberFormatException {
    String[] data = line.split(";");
    Producto producto = null;
    if (data.length == modelFieldsCount) {
      producto = new Producto();
      producto.setModeloProducto(data[0]);
      producto.setDescripcion(data[1]);
      producto.setPrecioVenta(Double.parseDouble(data[2]));
      producto.setCategoria(this.categoriasProductoDAO.getOne(Integer.parseInt(data[3])));
      producto.setEstado(Boolean.parseBoolean(data[4]) || Integer.parseInt(data[4]) > 0);
      Timestamps ts = new Timestamps();
      Date date = new Date();
      ts.setCreated_at(date);
      ts.setUpdated_at(date);
      producto.setTimestamps(ts);
    } else {
      this.getErrors().add(new String[]{"Se esperaban " + modelFieldsCount + ", se recibieron " + data.length, line});
    }
    return producto;
  }
  //</editor-fold>
}
