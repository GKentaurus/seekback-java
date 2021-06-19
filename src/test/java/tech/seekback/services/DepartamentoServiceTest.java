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
import tech.seekback.dao.interfaces.DepartamentoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Departamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.departamentoFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class DepartamentoServiceTest {
  @InjectMocks
  private DepartamentoService service;

  @Mock
  private DepartamentoDAO dao;

  private Departamento obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = departamentoFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    Departamento faker = departamentoFaker();
    when(dao.create(any(Departamento.class))).thenReturn(faker);

    Departamento persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    Departamento persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<Departamento> list = service.getAll();
    assertNotNull(list);
  }

  @Test
  public void getByIdPais() throws ConnectionExcep {
    List<Departamento> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(departamentoFaker());
    }
    when(dao.getByIdPais(anyInt())).thenReturn(fakerList);

    List<Departamento> persistedList = service.getByIdPais(1);
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
