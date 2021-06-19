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
import tech.seekback.dao.interfaces.EstadosCotizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosCotizacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.estadosCotizacionFaker;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class EstadosCotizacionServiceTest {
  @InjectMocks
  private EstadosCotizacionService service;

  @Mock
  private EstadosCotizacionDAO dao;

  private EstadosCotizacion obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = estadosCotizacionFaker();
  }

  @Test
  public void createOne() {
    EstadosCotizacion faker = estadosCotizacionFaker();
    EstadosCotizacion persisted = null;
    Exception exception = null;

    try {
      when(dao.create(any(EstadosCotizacion.class))).thenReturn(faker);
      persisted = service.create(faker);
    } catch (Exception e) {
      exception = e;
    }
    assertNull(exception);
    assertNotNull(persisted);
  }

  @Test
  public void createOneThrowsException() {
    EstadosCotizacion faker = estadosCotizacionFaker();
    EstadosCotizacion persisted = null;
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
    List<EstadosCotizacion> fakerList = new ArrayList<>();
    Exception exception = null;
    for (int i = 0; i < 4; i++) {
      fakerList.add(estadosCotizacionFaker());
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
    EstadosCotizacion fakerList = estadosCotizacionFaker();
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
    EstadosCotizacion persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<EstadosCotizacion> list = service.getAll();
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
