
package tech.seekback.controllers;

import tech.seekback.models.Calificacion;
import tech.seekback.services.CalificacionService;

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
public class CalificacionController extends CustomController implements Serializable {

  @EJB
  private CalificacionService calificacionService;
  private List<Calificacion> calificaciones;
  private List<Calificacion> calificaciondelproducto;

  public List<Calificacion> getCalificaciones() {
    try {
      if (Objects.isNull(calificaciones)) {
        calificaciones = calificacionService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los calificaciones.....");
      ex.printStackTrace();
    }
    return calificaciones;
  }

  public List<Calificacion> getCalificaciondelproducto(int idProducto) {
    try {
      if (Objects.isNull(calificaciondelproducto)) {
        calificaciondelproducto = calificacionService.getByIdProducto(idProducto);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los calificaciones.....");
      ex.printStackTrace();
    }
    return calificaciondelproducto;
  }

}
