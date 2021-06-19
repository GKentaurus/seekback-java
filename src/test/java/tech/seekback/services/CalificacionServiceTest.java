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
import tech.seekback.dao.interfaces.CalificacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Calificacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.calificacionFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class CalificacionServiceTest {
  @InjectMocks
  private CalificacionService service;

  @Mock
  private CalificacionDAO dao;

  private Calificacion obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = calificacionFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    Calificacion faker = calificacionFaker();
    when(dao.create(any(Calificacion.class))).thenReturn(faker);

    Calificacion persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    Calificacion persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getByidCliente() throws ConnectionExcep {
    List<Calificacion> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(calificacionFaker());
    }

    when(dao.getByidCliente(anyInt())).thenReturn(fakerList);
    List<Calificacion> persistedList = service.getByidCliente(1);

    assertFalse(persistedList.isEmpty());
    assertEquals(fakerList, persistedList);
  }

  @Test
  public void getByIdProducto() throws ConnectionExcep {
    List<Calificacion> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(calificacionFaker());
    }

    when(dao.getByIdProducto(anyInt())).thenReturn(fakerList);
    List<Calificacion> persistedList = service.getByIdProducto(1);

    assertFalse(persistedList.isEmpty());
    assertEquals(fakerList, persistedList);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<Calificacion> list = service.getAll();
    assertNotNull(list);
  }

  @Test
  public void getCalCount() throws ConnectionExcep {
    when(dao.getCalCountId(anyInt())).thenReturn(11);
    Integer count = service.getCalCount(1);
    assertNotNull(count);
    assertTrue(count > 0);
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
