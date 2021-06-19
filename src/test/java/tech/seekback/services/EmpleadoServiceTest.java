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
import tech.seekback.dao.interfaces.EmpleadoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.usuarioFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class EmpleadoServiceTest {
  @InjectMocks
  private EmpleadoService service;

  @Mock
  private EmpleadoDAO dao;

  private Usuario obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = usuarioFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    Usuario faker = usuarioFaker();
    when(dao.checkIfExist(any(), anyString(), any())).thenReturn(false);
    when(dao.create(any(Usuario.class))).thenReturn(faker);

    Usuario persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  public void createOneThrowException() {
    Usuario persisted = null;
    Exception exception = null;
    try {
      when(dao.checkIfExist(any(), anyString(), any())).thenReturn(true);
      persisted = service.create(obj);
    } catch (ConnectionExcep e) {
      exception = e;
    }

    assertNull(persisted);
    assertNotNull(exception);
  }

  @Test
  public void createAll() throws ConnectionExcep {
    List<Usuario> fakerList = new ArrayList<>();
    List<Usuario> errors;
    for (int i = 0; i < 4; i++) {
      fakerList.add(usuarioFaker());
    }
    errors = service.create(fakerList);
    assertNotNull(errors);
  }

  @Test
  public void createAllReturnErrors() throws ConnectionExcep {
    List<Usuario> fakerList = new ArrayList<>();
    List<Usuario> errors;
    for (int i = 0; i < 4; i++) {
      fakerList.add(usuarioFaker());
    }
    when(dao.checkIfExist(any(), anyString(), any())).thenReturn(true);
    errors = service.create(fakerList);
    assertNotNull(errors);
    assertEquals(fakerList.size(), errors.size());
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    Usuario persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<Usuario> list = service.getAll();
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
  public void delete() throws ConnectionExcep {
    Exception exception = null;
    try {
      service.delete(obj);
    } catch (ConnectionExcep e) {
      exception = e;
    }

    assertNull(exception);
  }
}
