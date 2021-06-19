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
import tech.seekback.dao.interfaces.EstadosFidelizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosFidelizacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.estadosFidelizacionFaker;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class EstadosFidelizacionServiceTest {
  @InjectMocks
  private EstadosFidelizacionService service;

  @Mock
  private EstadosFidelizacionDAO dao;

  private EstadosFidelizacion obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = estadosFidelizacionFaker();
  }

  @Test
  public void createOne() {
    EstadosFidelizacion faker = estadosFidelizacionFaker();
    EstadosFidelizacion persisted = null;
    Exception exception = null;

    try {
      when(dao.create(any(EstadosFidelizacion.class))).thenReturn(faker);
      persisted = service.create(faker);
    } catch (Exception e) {
      exception = e;
    }
    assertNull(exception);
    assertNotNull(persisted);
  }

  @Test
  public void createOneThrowsException() {
    EstadosFidelizacion faker = estadosFidelizacionFaker();
    EstadosFidelizacion persisted = null;
    Exception exception = null;
    try {
      when(dao.checkIfExist(any(), anyString(), any())).thenReturn(true);
      persisted = service.create(faker);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(persisted);
    assertNotNull(exception);
  }

  @Test
  public void createAll() {
    List<EstadosFidelizacion> fakerList = new ArrayList<>();
    Exception exception = null;
    for (int i = 0; i < 4; i++) {
      fakerList.add(estadosFidelizacionFaker());
    }
    try {
      service.create(fakerList);
    } catch (Exception e) {
      exception = e;
    }
    assertNull(exception);
  }

  @Test
  public void createAllThrowsException() {
    EstadosFidelizacion fakerList = estadosFidelizacionFaker();
    Exception exception = null;
    try {
      when(dao.checkIfExist(any(), anyString(), any())).thenReturn(true);
      service.create(fakerList);
    } catch (Exception e) {
      exception = e;
    }

    assertNotNull(exception);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    EstadosFidelizacion persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<EstadosFidelizacion> list = service.getAll();
    assertNotNull(list);
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
