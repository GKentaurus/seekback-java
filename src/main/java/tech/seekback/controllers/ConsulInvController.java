package tech.seekback.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.models.BodegaProducto;
import tech.seekback.services.BodegaProductoService;

@Named
@ViewScoped
public class ConsulInvController extends CustomController implements Serializable {

  @EJB
  private BodegaProductoService bodegaProductoService;

  private List<BodegaProducto> bodegaProductos;

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
}
