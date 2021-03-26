
package tech.seekback.controllers;

import tech.seekback.dao.interfaces.CiudadDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Ciudad;

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
public class CiudadController extends CustomController implements Serializable {

  @EJB
  private CiudadDAO ciudadDAO;
  private Integer idDepartamentoSeleccionado;
  private List<Ciudad> ciudadSeleccionada;

  public Integer getIdDepartamentoSeleccionado() {
    return idDepartamentoSeleccionado;
  }

  public void setIdDepartamentoSeleccionado(Integer idDepartamentoSeleccionado) {
    try {
      if (Objects.nonNull(idDepartamentoSeleccionado)) {
        ciudadSeleccionada = ciudadDAO
          .getByIdDepartamento(idDepartamentoSeleccionado);
      } else {
        ciudadSeleccionada = null;
      }
    } catch (ConnectionExcep ex) {
      ex.printStackTrace();
    }
    this.idDepartamentoSeleccionado = idDepartamentoSeleccionado;
  }

  public List<Ciudad> getCiudadSeleccionada() {
    return ciudadSeleccionada;
  }

}
