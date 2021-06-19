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
import tech.seekback.dao.interfaces.BodegaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Bodega;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.bodegaFaker;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class BodegaServiceTest {
  @InjectMocks
  private BodegaService service;

  @Mock
  private BodegaDAO dao;

  private Bodega obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = bodegaFaker();
  }

  @Test
  public void createOne() {
    Bodega faker = bodegaFaker();
    Bodega persisted = null;
    Exception exception = null;

    try {
      when(dao.create(any(Bodega.class))).thenReturn(faker);
      persisted = service.create(faker);
    } catch (Exception e) {
      exception = e;
    }
    assertNull(exception);
    assertNotNull(persisted);
  }

  @Test
  public void createOneThrowsException() {
    Bodega faker = bodegaFaker();
    Bodega persisted = null;
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
    List<Bodega> fakerList = new ArrayList<>();
    Exception exception = null;
    for (int i = 0; i < 4; i++) {
      fakerList.add(bodegaFaker());
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
    Bodega fakerList = bodegaFaker();
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
    Bodega persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<Bodega> list = service.getAll();
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
