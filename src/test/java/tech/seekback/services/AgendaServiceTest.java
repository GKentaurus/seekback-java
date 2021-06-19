package tech.seekback.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.seekback.dao.interfaces.AgendaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.agendaFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class AgendaServiceTest {
  @InjectMocks
  private AgendaService service;

  @Mock
  private AgendaDAO dao;

  private Agenda obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = agendaFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    Agenda faker = agendaFaker();
    when(dao.create(any(Agenda.class))).thenReturn(faker);

    Agenda persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    Agenda persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<Agenda> list = service.getAll();
    assertNotNull(list);
  }

  @Test
  public void getByIdEmpleado() throws ConnectionExcep {
    List<Agenda> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(agendaFaker());
    }
    when(dao.getByidEmpleado(anyInt())).thenReturn(fakerList);
    List<Agenda> persistedList = service.getByidEmpleado(1);
    assertTrue(persistedList.size() > 0);
  }

  @Test
  public void getByIdCliente() throws ConnectionExcep {
    List<Agenda> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(agendaFaker());
    }
    when(dao.getByidCliente(anyInt())).thenReturn(fakerList);
    List<Agenda> persistedList = service.getByidCliente(1);
    assertTrue(persistedList.size() > 0);
  }


  @Test
  public void update() {
    Exception exception = null;
    try {
      service.update(obj);
    } catch (ConnectionExcep e) {
      exception = e;
    }

    assertNull(exception);
  }

  @Test
  public void delete() {
    Exception exception = null;
    try {
      service.delete(obj);
    } catch (ConnectionExcep e) {
      exception = e;
    }

    assertNull(exception);
  }
}
