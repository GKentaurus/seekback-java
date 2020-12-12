/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.models.EstadosFidelizacion;
import tech.seekback.models.SoporteTecnico;
import tech.seekback.services.EstadosFidelizacionService;
import tech.seekback.services.SoporteTecnicoService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class SoporteTecnicoController implements Serializable {

  @EJB
  private SoporteTecnicoService soporteTecnicoService;

  @EJB
  private EstadosFidelizacionService estadosFidelizacionService;
  private SoporteTecnico soporteTecnico;
  private List<SoporteTecnico> soportes;
  private List<EstadosFidelizacion> estados;

  public List<SoporteTecnico> getSoportes() {
    try {
      if (Objects.isNull(soportes)) {
        soportes = soporteTecnicoService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los soporteTecnico.....");
      ex.printStackTrace();
    }
    return soportes;
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

}
