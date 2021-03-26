
package tech.seekback.controllers;

import tech.seekback.dao.interfaces.DepartamentoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Departamento;

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
public class DepartamentoController extends CustomController implements Serializable {

  @EJB
  private DepartamentoDAO departamentoDAO;
  private Integer idPaisSeleccionado;
  private List<Departamento> departamentoSeleccionado;

  public Integer getIdPaisSeleccionado() {
    return idPaisSeleccionado;
  }

  public void setIdPaisSeleccionado(Integer idPaisSeleccionado) {
    try {
      if (Objects.nonNull(idPaisSeleccionado)) {
        departamentoSeleccionado = departamentoDAO
          .getByIdPais(idPaisSeleccionado);
      } else {
        departamentoSeleccionado = null;
      }
    } catch (ConnectionExcep ex) {
      ex.printStackTrace();
    }
    this.idPaisSeleccionado = idPaisSeleccionado;
  }

  public List<Departamento> getDepartamentoSeleccionado() {
    return departamentoSeleccionado;
  }

}
