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
import tech.seekback.dao.interfaces.CotizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cotizacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.cotizacionFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class CotizacionServiceTest {
  @InjectMocks
  private CotizacionService service;

  @Mock
  private CotizacionDAO dao;

  private Cotizacion obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = cotizacionFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    Cotizacion faker = cotizacionFaker();
    when(dao.create(any(Cotizacion.class))).thenReturn(faker);

    Cotizacion persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    Cotizacion persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<Cotizacion> list = service.getAll();
    assertNotNull(list);
  }

  @Test
  public void getByIdEmpleado() throws ConnectionExcep {
    List<Cotizacion> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(cotizacionFaker());
    }
    when(dao.getByIdEmpleado(anyInt())).thenReturn(fakerList);
    List<Cotizacion> persistedList = service.getByIdEmpleado(1);
    assertTrue(persistedList.size() > 0);
  }

  @Test
  public void getByIdCliente() throws ConnectionExcep {
    List<Cotizacion> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(cotizacionFaker());
    }
    when(dao.getByIdCliente(anyInt())).thenReturn(fakerList);
    List<Cotizacion> persistedList = service.getByIdCliente(1);
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
