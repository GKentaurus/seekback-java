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
import tech.seekback.dao.interfaces.TRMDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TRM;

import javax.servlet.http.Part;
import java.util.Collections;
import java.util.List;

import static faker.FakerData.trmFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class TRMServiceTest {
  @InjectMocks
  private TRMService service;

  @Mock
  private TRMDAO dao;

  private TRM obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = trmFaker();
  }

  @Test
  public void createOne() {
    TRM faker = trmFaker();
    TRM persisted = null;
    Exception exception = null;

    try {
      when(dao.create(any(TRM.class))).thenReturn(faker);
      persisted = service.create(faker);
    } catch (Exception e) {
      exception = e;
    }
    assertNull(exception);
    assertNotNull(persisted);
  }

  @Test
  @Disabled
  public void createOneThrowsException() {
    TRM faker = trmFaker();
    TRM persisted = null;
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
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    TRM persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<TRM> list = service.getAll();
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
