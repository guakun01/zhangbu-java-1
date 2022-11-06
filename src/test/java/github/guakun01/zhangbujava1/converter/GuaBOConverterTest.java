package github.guakun01.zhangbujava1.converter;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import github.guakun01.zhangbujava1.converter.DO2BO.GuaBoConverter;
import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.persistence.GuaDO;

class GuaBOConverterTest {
  private GuaBoConverter guaBOConverter = new GuaBoConverter();

  @Test
  void testDoForward() {

    long id = 1L;
    // arrange
    String displayName = "xg";
    String innerId = "xxg";
    LocalDate createAt = LocalDate.now();
    String salt = UUID.randomUUID().toString();

    GuaDO guaDO = GuaDO.builder()
        .id(id)
        .displayName(displayName)
        .innerId(innerId)
        .salt(salt)
        .createAt(createAt)
        .build();
    // act
    GuaBO res = guaBOConverter.convert(guaDO);
    assertThat(res).isNotNull()
        .hasFieldOrPropertyWithValue("id", id)
        .hasFieldOrPropertyWithValue("displayName", displayName)
        .hasFieldOrPropertyWithValue("innerId", innerId)
        .hasFieldOrPropertyWithValue("salt", salt);

  }

  @Test
  void testDoBackward() {

    long id = 1L;
    // arrange
    String displayName = "xg";
    String innerId = "xxg";
    String salt = UUID.randomUUID().toString();

    GuaBO guaBO = GuaBO.builder()
        .id(id)
        .displayName(displayName)
        .innerId(innerId)
        .salt(salt)
        .build();
    // act
    GuaDO res = guaBOConverter.reverse().convert(guaBO);
    assertThat(res).isNotNull()
        .hasFieldOrPropertyWithValue("id", id)
        .hasFieldOrPropertyWithValue("displayName", displayName)
        .hasFieldOrPropertyWithValue("createAt", null)
        .hasFieldOrPropertyWithValue("modifiedAt", null)
        .hasFieldOrPropertyWithValue("salt", salt)
        .hasFieldOrPropertyWithValue("innerId", innerId);

  }
}