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
import tech.seekback.dao.interfaces.BodegaProductoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.BodegaProducto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.bodegaProductoFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class BodegaProductoServiceTest {
  @InjectMocks
  private BodegaProductoService service;

  @Mock
  private BodegaProductoDAO dao;

  private BodegaProducto obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = bodegaProductoFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    BodegaProducto faker = bodegaProductoFaker();
    when(dao.create(any(BodegaProducto.class))).thenReturn(faker);

    BodegaProducto persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    BodegaProducto persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getByIdCategoria() throws ConnectionExcep {
    List<BodegaProducto> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(bodegaProductoFaker());
    }
    when(dao.getByIdCategoria(anyInt())).thenReturn(fakerList);
    List<BodegaProducto> persisted = service.getByIdCategoria(1);
    assertTrue(persisted.size() > 0);
  }

  @Test
  public void getByIdProducto() throws ConnectionExcep {
    when(dao.getByIdProducto(anyInt())).thenReturn(obj);
    BodegaProducto persisted = service.getByIdProducto(1);
    assertNotNull(persisted);
    assertEquals(obj, persisted);
  }

  @Test
  public void getLikeName() throws ConnectionExcep {
    List<BodegaProducto> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(bodegaProductoFaker());
    }
    when(dao.getLikeName(anyString())).thenReturn(fakerList);
    List<BodegaProducto> persisted = service.getLikeName("Producto");
    assertTrue(persisted.size() > 0);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<BodegaProducto> list = service.getAll();
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
