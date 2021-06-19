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
import tech.seekback.dao.interfaces.CiudadDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Ciudad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.ciudadFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class CiudadServiceTest {
  @InjectMocks
  private CiudadService service;

  @Mock
  private CiudadDAO dao;

  private Ciudad obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = ciudadFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    Ciudad faker = ciudadFaker();
    when(dao.create(any(Ciudad.class))).thenReturn(faker);

    Ciudad persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    Ciudad persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<Ciudad> list = service.getAll();
    assertNotNull(list);
  }

  @Test
  public void getByIdDepartamento() throws ConnectionExcep {
    List<Ciudad> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(ciudadFaker());
    }
    when(dao.getByIdDepartamento(anyInt())).thenReturn(fakerList);
    List<Ciudad> persisted = service.getByIdDepartamento(1);
    assertTrue(persisted.size() > 0);
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
