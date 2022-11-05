package github.guakun01.zhangbujava1.converter;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import github.guakun01.zhangbujava1.converter.DO2BO.GuaBOConverter;
import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.persistence.GuaDO;

class GuaBOConverterTest {
  private GuaBOConverter guaBOConverter = new GuaBOConverter();

  @Test
  void testDoForward() {

    long id = 1L;
    // arrange
    String displayName = "xg";
    String innerId = "xxg";
    LocalDate createAt = LocalDate.now();

    GuaDO guaDO = GuaDO.builder()
        .id(id)
        .displayName(displayName)
        .innerId(innerId)
        .createAt(createAt)
        .build();
    // act
    GuaBO res = guaBOConverter.convert(guaDO);
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

    GuaBO guaBO = GuaBO.builder()
        .id(id)
        .displayName(displayName)
        .innerId(innerId)
        .build();
    // act
    GuaDO res = guaBOConverter.reverse().convert(guaBO);
    assertThat(res).isNotNull()
        .hasFieldOrPropertyWithValue("id", id)
        .hasFieldOrPropertyWithValue("displayName", displayName)
        .hasFieldOrPropertyWithValue("createAt", null)
        .hasFieldOrPropertyWithValue("modifiedAt", null)
        .hasFieldOrPropertyWithValue("innerId", innerId);

  }
}