package tech.seekback.controllers;

import tech.seekback.models.BodegaProducto;
import tech.seekback.services.BodegaProductoService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;

@Named
@ViewScoped
public class ConsulInvController extends CustomController {

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
