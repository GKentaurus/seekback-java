package tech.seekback.dao.jpa;

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

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class PQRSDAOJPATest {
  @InjectMocks
  private PQRSDAOJPA daoMock;

  @Mock
  private EntityManager emMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @Disabled
  public void getAllCount() throws Exception {
    TypedQuery queryMock = mock(TypedQuery.class);

    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(anyInt());
    when(this.daoMock.getAllCount()).thenReturn(1);

    Integer count = this.daoMock.getAllCount();
    assertNotNull(count);
    assertNotEquals(0, count);
  }

  @Test
  public void getAllCountThrowsException() throws Exception {
    Integer count = null;
    Exception exception = null;

    try {
      count = daoMock.getAllCount();
    } catch (Exception e) {
      exception = e;
    }

    assertNull(count);
    assertNotNull(exception);
  }
}
