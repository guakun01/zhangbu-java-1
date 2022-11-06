package github.guakun01.zhangbujava1.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import github.guakun01.zhangbujava1.converter.BO2VO.GuaVoConverter;
import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.service.GuaVO;

class GuaVOConverterTest {
  private GuaVoConverter guaVOConverter = new GuaVoConverter();

  @Test
  void testDoForward() {

    long id = 1L;
    // arrange
    String displayName = "xg";
    String innerId = "xxg";

    GuaBO guaBO = GuaBO.builder()
        .id(id)
        .displayName(displayName)
        .innerId(innerId)
        .build();
    // act
    GuaVO res = guaVOConverter.convert(guaBO);
    assertThat(res).isNotNull()
        .hasFieldOrPropertyWithValue("id", id)
        .hasFieldOrPropertyWithValue("displayName", displayName);

  }

  @Test
  void testDoBackward() {

    long id = 1L;
    // arrange
    String displayName = "xg";

    GuaVO guaVO = GuaVO.builder()
        .id(id)
        .displayName(displayName)
        .build();
    // act
    GuaBO res = guaVOConverter.reverse().convert(guaVO);
    assertThat(res).isNotNull()
        .hasFieldOrPropertyWithValue("id", id)
        .hasFieldOrPropertyWithValue("displayName", displayName);
  }
}