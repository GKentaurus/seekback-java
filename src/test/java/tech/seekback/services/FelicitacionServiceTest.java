package tech.seekback.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.seekback.dao.interfaces.FelicitacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Felicitacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.felicitacionFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class FelicitacionServiceTest {
  @InjectMocks
  private FelicitacionService service;

  @Mock
  private FelicitacionDAO dao;

  private Felicitacion obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = felicitacionFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    Felicitacion faker = felicitacionFaker();
    when(dao.create(any(Felicitacion.class))).thenReturn(faker);

    Felicitacion persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  @Disabled
  public void createOneThrowsException() {
    Felicitacion faker = felicitacionFaker();
    Felicitacion persisted = null;
    Exception exception = null;

    try {
      when(dao.checkIfExist(any(), anyString(), any())).thenReturn(false);
      when(dao.create(any(Felicitacion.class))).thenReturn(faker);

      persisted = service.create(faker);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(persisted);
    assertNotNull(exception);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    Felicitacion persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<Felicitacion> list = service.getAll();
    assertNotNull(list);
  }

  @Test
  public void getByidCliente() throws ConnectionExcep {
    List<Felicitacion> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(felicitacionFaker());
    }
    when(dao.getByidCliente(anyInt())).thenReturn(fakerList);
    List<Felicitacion> persistedList = service.getByidCliente(1);
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
