package github.guakun01.zhangbujava1.manager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import github.guakun01.zhangbujava1.converter.DO2BO.GuaBoConverter;
import github.guakun01.zhangbujava1.dao.GuaDAO;
import github.guakun01.zhangbujava1.exception.ResourceNotFoundException;
import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.persistence.GuaDO;

public class GuaManagerTest {

  private GuaManager guaManager;

  @Mock
  private GuaDAO guaDAO;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    guaManager = new GuaManagerImpl(guaDAO, new GuaBoConverter());
  }

  @Test
  void testGetGuaById() {
    // Arrange
    long id = 1L;

    String displayName = "xg";
    String innerId = "xxg";
    LocalDate createAt = LocalDate.now();

    GuaDO guaDO = GuaDO.builder()
    .id(id)
    .displayName(displayName)
    .innerId(innerId)
    .createAt(createAt)
    .build();

    doReturn(guaDO).when(guaDAO).getGuaById(id);

    // Act
    GuaBO res = guaManager.getGuaById(id);

    // Assert
    assertThat(res).isNotNull()
      .hasFieldOrPropertyWithValue("id", id)
      .hasFieldOrPropertyWithValue("displayName", displayName)
      .hasFieldOrPropertyWithValue("innerId", innerId);

    verify(guaDAO).getGuaById(eq(id));

  }

  @Test
  void testGetGuaByIdWithInvalidGuaId() {
 // Arrange
    long id = -1L;
    
    doReturn(null).when(guaDAO).getGuaById(id);
    // Act && Assert
    assertThrows(ResourceNotFoundException.class, () -> guaManager.getGuaById(id));

    verify(guaDAO).getGuaById(eq(id));
  }

}
