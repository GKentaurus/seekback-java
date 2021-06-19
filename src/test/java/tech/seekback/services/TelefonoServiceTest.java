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
import tech.seekback.dao.interfaces.TelefonoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Telefono;

import java.util.Collections;
import java.util.List;

import static faker.FakerData.telefonoFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class TelefonoServiceTest {
  @InjectMocks
  private TelefonoService service;

  @Mock
  private TelefonoDAO dao;

  private Telefono obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = telefonoFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    Telefono faker = telefonoFaker();
    when(dao.create(any(Telefono.class))).thenReturn(faker);

    Telefono persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    Telefono persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<Telefono> list = service.getAll();
    assertNotNull(list);
  }

  @Test
  public void getByIdUsuario() throws ConnectionExcep {
    when(dao.getByIdUsuario(anyInt())).thenReturn(obj);
    Telefono persisted = service.getByIdUsuario(1);

    assertNotNull(persisted);
    assertEquals(obj, persisted);
  }

  @Test
  public void getByIdPrincipal() throws ConnectionExcep {
    when(dao.getByIdPrincipal(anyInt())).thenReturn(obj);
    Telefono persisted = service.getByIdPrincipal(1);

    assertNotNull(persisted);
    assertEquals(obj, persisted);
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
