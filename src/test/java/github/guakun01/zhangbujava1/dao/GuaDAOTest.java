package github.guakun01.zhangbujava1.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import github.guakun01.zhangbujava1.dao.mapper.GuaMapper;
import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.persistence.GuaDO;

@ExtendWith(MockitoExtension.class)
public class GuaDAOTest {

  @Mock
  private GuaMapper guaMapper;

  @InjectMocks
  private GuaDAOImpl guaDAO;

  // @BeforeEach
  // void setup() {
  //   guaDAO = new GuaDAOImpl(guaMapper);
  // }

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
    .modifiedAt(createAt)
    .build();

    doReturn(guaDO).when(guaMapper).getGuaById(id);

    // Act
    GuaDO res = guaDAO.getGuaById(id);

    // Assert
    assertThat(res).isNotNull()
      .hasFieldOrPropertyWithValue("id", id)
      .hasFieldOrPropertyWithValue("displayName", displayName)
      .hasFieldOrPropertyWithValue("createAt", createAt)
      .hasFieldOrPropertyWithValue("modifiedAt", createAt)
      .hasFieldOrPropertyWithValue("innerId", innerId);

    verify(guaMapper).getGuaById(eq(id));

  }

}
