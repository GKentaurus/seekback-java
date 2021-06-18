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
import tech.seekback.models.TRM;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class TRMDAOJPATest {
  @InjectMocks
  private TRMDAOJPA daoMock;

  @Mock
  EntityManager emMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getByIdUsuario() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);

    Integer id = 1;
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.setMaxResults(anyInt())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<TRM> list = daoMock.getByidDivisa(1);

    assertNotNull(list);
  }

  @Test
  public void getByIdUsuarioThrowsException() {
    List<TRM> list = null;
    Exception exception = null;

    try {
      when(daoMock.getByidDivisa(anyInt())).thenThrow(new Exception()).thenReturn(null);
      list = daoMock.getByidDivisa(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }
}
