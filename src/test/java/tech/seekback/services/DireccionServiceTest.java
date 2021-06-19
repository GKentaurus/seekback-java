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
import tech.seekback.dao.interfaces.DireccionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Direccion;

import java.util.Collections;
import java.util.List;

import static faker.FakerData.direccionFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class DireccionServiceTest {
  @InjectMocks
  private DireccionService service;

  @Mock
  private DireccionDAO dao;

  private Direccion obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = direccionFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    Direccion faker = direccionFaker();
    when(dao.create(any(Direccion.class))).thenReturn(faker);

    Direccion persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    Direccion persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<Direccion> list = service.getAll();
    assertNotNull(list);
  }

  @Test
  public void getByIdPrincipal() throws ConnectionExcep {
    Direccion faker = direccionFaker();
    when(dao.getByIdPrincipal(anyInt())).thenReturn(faker);

    Direccion persisted = service.getByIdPrincipal(1);
    assertNotNull(persisted);
    assertEquals(faker, persisted);
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
