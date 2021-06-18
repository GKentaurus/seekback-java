package tech.seekback.dao.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class TipoDocDAOJPATest {
  @InjectMocks
  private TipoDocDAOJPA daoMock;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void constructorTest() {
    assertNotNull(this.daoMock);
    assertEquals(TipoDocDAOJPA.class, this.daoMock.getClass());
  }
}
