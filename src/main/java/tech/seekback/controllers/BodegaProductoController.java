
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.BodegaProducto;
import tech.seekback.models.Producto;
import tech.seekback.services.BodegaProductoService;
import tech.seekback.services.ProductoService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author danny
 */
@Named
@ViewScoped
public class BodegaProductoController extends CustomController implements Serializable {

  @EJB
  private BodegaProductoService bodegaProductoService;
  @EJB
  private ProductoService productoService;
  private List<BodegaProducto> bodegaProductos;
  private List<BodegaProducto> productosporcategoria;
  private List<BodegaProducto> pornombre;
  private BodegaProducto bodegaProducto;
  private Producto producto;

  public List<BodegaProducto> getBodegaProductos() {
    try {
      if (Objects.isNull(bodegaProductos)) {
        bodegaProductos = bodegaProductoService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los bodegaProductos.....");
      ex.printStackTrace();
    }
    return bodegaProductos;
  }

  public void getOne(int idProducto) throws ConnectionExcep {
    this.producto = productoService.getOne(idProducto);
  }

  public Producto getProducto() {
    try {
      if (Objects.isNull(producto)) {
        System.out.println("vacio esto");
      }
    } catch (Exception e) {
    }
    return producto;
  }

  /**
   * @param idProducto
   * @return
   */
  public List<BodegaProducto> getProductosporcategoria(int idProducto) {
    try {
      if (Objects.isNull(productosporcategoria)) {
        productosporcategoria = bodegaProductoService.getByIdCategoria(idProducto);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los bodegaProductos.....");
      ex.printStackTrace();
    }
    return productosporcategoria;
  }

  /**
   * @param parteNombre
   * @return
   */
  public List<BodegaProducto> getPornombre(String parteNombre) {
    try {
      if (Objects.isNull(pornombre)) {
        pornombre = bodegaProductoService.getLikeName(parteNombre);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los bodegaProductos.....");
      ex.printStackTrace();
    }
    return pornombre;
  }

}
