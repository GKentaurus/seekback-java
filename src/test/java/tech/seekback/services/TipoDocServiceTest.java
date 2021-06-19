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
import tech.seekback.dao.interfaces.TipoDocDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoDoc;

import java.util.Collections;
import java.util.List;

import static faker.FakerData.tipoDocFaker;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class TipoDocServiceTest {
  @InjectMocks
  private TipoDocService service;

  @Mock
  private TipoDocDAO dao;

  private TipoDoc obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    obj = tipoDocFaker();
  }

  @Test
  public void createOne() throws ConnectionExcep {
    TipoDoc faker = tipoDocFaker();
    when(dao.create(any(TipoDoc.class))).thenReturn(faker);

    TipoDoc persisted = service.create(faker);
    assertNotNull(persisted);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    when(dao.getOne(anyInt())).thenReturn(obj);
    TipoDoc persisted = service.getOne(1);
    assertNotNull(persisted);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    when(dao.getAll()).thenReturn(Collections.emptyList());
    List<TipoDoc> list = service.getAll();
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
