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
  private Integer countcal;
  private Integer countcal2;
  private Integer countcal3;
  private Integer countcal4;
  private Integer countcal5;

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

  public Integer getCountcal(int idCal) {
    try {
      if (countcal == null) {
        countcal = calificacionService.getCalCountId(idCal);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countcal;
  }

  public Integer getCountcal2() {
    try {
      if (countcal2 == null) {
        countcal2 = calificacionService.getCalCount2();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countcal2;
  }

  public Integer getCountcal3() {
    try {
      if (countcal3 == null) {
        countcal3 = calificacionService.getCalCount3();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countcal3;
  }

  public Integer getCountcal4() {
    try {
      if (countcal4 == null) {
        countcal4 = calificacionService.getCalCount4();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countcal4;
  }

  public Integer getCountcal5() {
    try {
      if (countcal5 == null) {
        countcal5 = calificacionService.getCalCount5();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countcal5;
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
