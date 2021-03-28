
package tech.seekback.controllers;

import tech.seekback.models.Usuario;
import tech.seekback.services.ClienteService;

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
public class ClienteController extends CustomController implements Serializable {

  @EJB
  private ClienteService clienteService;
  private List<Usuario> clientes;

  public List<Usuario> getClientes() {
    try {
      if (Objects.isNull(clientes)) {
        clientes = clienteService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los clientes.....");
      ex.printStackTrace();
    }
    return clientes;
  }

}
