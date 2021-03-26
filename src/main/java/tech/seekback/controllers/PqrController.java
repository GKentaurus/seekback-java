
package tech.seekback.controllers;

import tech.seekback.models.EstadosFidelizacion;
import tech.seekback.models.PQRS;
import tech.seekback.models.TipoSolicitud;
import tech.seekback.services.EstadosFidelizacionService;
import tech.seekback.services.PQRSService;
import tech.seekback.services.TipoSolicitudService;

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
public class PqrController extends CustomController implements Serializable {

  @EJB
  private PQRSService pQRSService;

  @EJB
  private EstadosFidelizacionService estadosFidelizacionService;

  @EJB
  private TipoSolicitudService tipoSolicitudService;
  private List<PQRS> pqrses;
  private List<EstadosFidelizacion> estados;
  private List<TipoSolicitud> tipoSolicitudes;
  private PQRS pqrs;
  private Integer count;

  public Integer getCount() {
    try {
      if (count == null) {
        count = pQRSService.getAllCount();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return count;
  }

  public List<PQRS> getPqrses() {
    try {
      if (Objects.isNull(pqrses)) {
        pqrses = pQRSService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los pqrses.....");
      ex.printStackTrace();
    }
    return pqrses;
  }

  public List<EstadosFidelizacion> getEstadosFidelizacion() {
    try {
      if (Objects.isNull(estados)) {
        estados = estadosFidelizacionService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los estadosFidelizacion.....");
      ex.printStackTrace();
    }
    return estados;
  }

  public List<TipoSolicitud> getTipoSolicitudes() {
    try {
      if (Objects.isNull(tipoSolicitudes)) {
        tipoSolicitudes = tipoSolicitudService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los tipoSolicitudes.....");
      ex.printStackTrace();
    }
    return tipoSolicitudes;
  }

}
