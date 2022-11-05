package github.guakun01.zhangbujava1.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import github.guakun01.zhangbujava1.converter.BO2VO.GuaVOConverter;
import github.guakun01.zhangbujava1.converter.DO2BO.GuaBOConverter;
import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.service.GuaVO;

class GuaVOConverterTest {
  private GuaVOConverter guaVOConverter = new GuaVOConverter();

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
        .hasFieldOrPropertyWithValue("displayName", displayName)
        .hasFieldOrPropertyWithValue("innerId", innerId);

  }

  @Test
  void testDoBackward() {

    long id = 1L;
    // arrange
    String displayName = "xg";
    String innerId = "xxg";

    GuaVO guaVO = GuaVO.builder()
        .id(id)
        .displayName(displayName)
        .innerId(innerId)
        .build();
    // act
    GuaBO res = guaVOConverter.reverse().convert(guaVO);
    assertThat(res).isNotNull()
        .hasFieldOrPropertyWithValue("id", id)
        .hasFieldOrPropertyWithValue("displayName", displayName)
        .hasFieldOrPropertyWithValue("innerId", innerId);

  }
}