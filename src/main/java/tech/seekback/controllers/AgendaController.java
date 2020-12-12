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
import tech.seekback.models.Agenda;
import tech.seekback.models.EstadosAgenda;
import tech.seekback.models.TipoServicio;
import tech.seekback.services.AgendaService;
import tech.seekback.services.EstadosAgendaService;
import tech.seekback.services.TipoServicioService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class AgendaController implements Serializable {

  @EJB
  private EstadosAgendaService estadosAgendaService;

  @EJB
  private TipoServicioService tipoServicioService;

  @EJB
  private AgendaService agendaService;
  private List<Agenda> agendas;
  private List<EstadosAgenda> estadosAgendas;
  private List<TipoServicio> tipoServicio;

  public List<Agenda> getAgendas() {
    try {
      if (Objects.isNull(agendas)) {
        agendas = agendaService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los Agenda.....");
      ex.printStackTrace();
    }
    return agendas;
  }

  public List<EstadosAgenda> getEstadosAgendas() {
    try {
      if (Objects.isNull(estadosAgendas)) {
        estadosAgendas = estadosAgendaService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los EstadosAgenda.....");
      ex.printStackTrace();
    }
    return estadosAgendas;
  }

  public List<TipoServicio> getTipoServicio() {
    try {
      if (Objects.isNull(tipoServicio)) {
        tipoServicio = tipoServicioService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los TipoServicio.....");
      ex.printStackTrace();
    }
    return tipoServicio;
  }

}
