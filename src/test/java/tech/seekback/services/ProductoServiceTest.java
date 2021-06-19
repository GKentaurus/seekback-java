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
import tech.seekback.dao.interfaces.ProductoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Producto;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.productoFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ProductoServiceTest {
  @InjectMocks
  private ProductoService service;

  @Mock
  private ProductoDAO dao;

  private Producto obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = productoFaker();
  }

  @Test
  public void createOne() {
    Producto faker = productoFaker();
    Producto persisted = null;
    Exception exception = null;

    try {
      when(dao.create(any(Producto.class))).thenReturn(faker);
      persisted = service.create(faker);
    } catch (Exception e) {
      exception = e;
    }
    assertNull(exception);
    assertNotNull(persisted);
  }

  @Test
  public void createOneThrowsException() {
    Producto faker = productoFaker();
    Producto persisted = null;
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
    List<Producto> fakerList = new ArrayList<>();
    Exception exception = null;
    for (int i = 0; i < 4; i++) {
      fakerList.add(productoFaker());
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
    Producto fakerList = productoFaker();
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
    Producto persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<Producto> list = service.getAll();
    assertNotNull(list);
  }

  @Test
  public void getCategoryCount() throws ConnectionExcep {
    when(dao.getCatCount(anyInt())).thenReturn(11);
    Integer count = service.getCategoryCount(1);
    assertNotNull(count);
    assertTrue(count > 0);
  }

  @Test
  public void getCategoryProducts() throws ConnectionExcep {
    List<Producto> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(productoFaker());
    }

    when(dao.getCategoryProducts(anyInt())).thenReturn(fakerList);
    List<Producto> persisted = service.getCategoryProducts(1);

    assertNotNull(persisted);
    assertFalse(persisted.isEmpty());
  }

  @Test
  public void getLastProducts() throws ConnectionExcep {
    List<Producto> fakerList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakerList.add(productoFaker());
    }

    when(dao.getLastProducts(anyInt())).thenReturn(fakerList);
    List<Producto> persisted = service.getLastProducts(1);

    assertNotNull(persisted);
    assertFalse(persisted.isEmpty());
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

  @Test
  public void partTest() {
    Part part = mock(Part.class);
    service.setPart(part);
    assertNotNull(service.getPart());
    assertEquals(part, service.getPart());
  }

  @Test
  @Disabled
  public void uploadData() throws Exception {
    // TODO: Pendiente por implementar
  }
}
