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
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static faker.FakerData.usuarioFaker;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class UsuarioDAOJPATest {
  @InjectMocks
  private UsuarioDAOJPA daoMock;

  @Mock
  private EntityManager emMock;

  private Usuario obj;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    this.obj = usuarioFaker();
  }

  @Test
  public void constructorTest() {
    assertNotNull(this.daoMock);
    assertEquals(UsuarioDAOJPA.class, this.daoMock.getClass());
  }

  @Test
  public void createOneTest() throws ConnectionExcep {
    when(emMock.merge(any())).thenReturn(obj);
    Usuario persistedUsuario = this.daoMock.create(obj);

    assertNotNull(persistedUsuario);
  }

  @Test
  public void createListTest() throws ConnectionExcep {
    List<Usuario> list = new ArrayList<>();
    list.add(obj);
    this.daoMock.create(list);
  }

  @Test
  public void getOneTest() throws ConnectionExcep {
    when(emMock.find(any(), anyInt())).thenReturn(obj);
    Usuario persistedUsuario = this.daoMock.getOne(1);

    assertNotNull(persistedUsuario);
  }

  @Test
  public void updateTest() throws ConnectionExcep {
    this.daoMock.update(obj);
  }

  @Test
  public void deleteTest() throws ConnectionExcep {
    obj.getTimestamps().setDeleted(true);
    obj.getTimestamps().setDeleted_at(new Date());
    this.daoMock.delete(obj);
  }

  @Test
  @Disabled
  public void checkIfExistTest() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyString())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(obj);
    when(daoMock.checkIfExist(obj, anyString(), anyString())).thenReturn(true);
    boolean response = this.daoMock.checkIfExist(obj, "", "");
    assertTrue(response);
  }
}
