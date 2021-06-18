package tech.seekback.dao.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Ciudad;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class CiudadDAOJPATest {
  @InjectMocks
  private CiudadDAOJPA daoMock;

  @Mock
  EntityManager emMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getByIdDepartamento() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);

    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Ciudad> list = this.daoMock.getByIdDepartamento(1);
    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getByIdDepartamentoThrowsException() {
    List<Ciudad> list = null;
    Exception exception = null;

    try {
      list = daoMock.getByIdDepartamento(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }
}
