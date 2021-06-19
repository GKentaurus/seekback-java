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
import tech.seekback.dao.interfaces.SoporteTecnicoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.SoporteTecnico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.soporteTecnicoFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class SoporteTecnicoServiceTest {
  @InjectMocks
  private SoporteTecnicoService service;

  @Mock
  private SoporteTecnicoDAO dao;

  private SoporteTecnico obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = soporteTecnicoFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    SoporteTecnico faker = soporteTecnicoFaker();
    when(dao.create(any(SoporteTecnico.class))).thenReturn(faker);

    SoporteTecnico persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    SoporteTecnico persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getByidEmpleado() throws ConnectionExcep {
    List<SoporteTecnico> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(soporteTecnicoFaker());
    }
    when(dao.getByidEmpleado(anyInt())).thenReturn(fakerList);
    List<SoporteTecnico> persistedList = service.getByidEmpleado(1);
    assertTrue(persistedList.size() > 0);
  }

  @Test
  public void getByidCliente() throws ConnectionExcep {
    List<SoporteTecnico> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(soporteTecnicoFaker());
    }
    when(dao.getByidCliente(anyInt())).thenReturn(fakerList);
    List<SoporteTecnico> persistedList = service.getByidCliente(1);
    assertTrue(persistedList.size() > 0);
  }

  @Test
  public void getAllCount() throws ConnectionExcep {
    when(dao.getAllCount()).thenReturn(11);
    Integer count = service.getAllCount();
    assertNotNull(count);
    assertTrue(count > 0);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<SoporteTecnico> list = service.getAll();
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
