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
import tech.seekback.services.AgendaService;
import tech.seekback.services.EstadosAgendaService;

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
  private EstadosAgendaService estadosAgendaService;

  @EJB
  private AgendaService agendaService;
  private List<Agenda> agendas;
  private List<EstadosAgenda> estadosAgendas;

  public List<Agenda> getCalificaciones() {
    try {
      if (Objects.isNull(agendas)) {
        agendas = agendaService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los calificaciones.....");
      ex.printStackTrace();
    }
    return agendas;
  }

}
