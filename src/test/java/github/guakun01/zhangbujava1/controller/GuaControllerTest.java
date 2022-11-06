package github.guakun01.zhangbujava1.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import github.guakun01.zhangbujava1.converter.BO2VO.GuaVoConverter;
import github.guakun01.zhangbujava1.exception.GlobalExceptionHandler;
import github.guakun01.zhangbujava1.exception.ResourceNotFoundException;
import github.guakun01.zhangbujava1.manager.GuaManager;
import github.guakun01.zhangbujava1.model.common.GuaBO;

@ExtendWith(MockitoExtension.class)
public class GuaControllerTest {

  private MockMvc mockMvc;

  @Mock
  GuaManager guaManager;

  @BeforeEach
  void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(
        new GuaController(guaManager, new GuaVoConverter())).setControllerAdvice(new GlobalExceptionHandler())
        .build();
  }

  @AfterEach
  void teardown() {
    reset(guaManager);
  }

  @Test
  void testGetGuaById() throws Exception {
    // Arrange
    long id = 1L;

    String displayName = "xg";
    String innerId = "xxg";

    GuaBO guaBO = GuaBO.builder()
        .id(id)
        .displayName(displayName)
        .innerId(innerId)
        .build();

    doReturn(guaBO).when(guaManager).getGuaById(anyLong());

    // Act && Assert
    mockMvc.perform(get("/api/v1/gua/" + id))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"id\":1,\"displayName\":\"xg\"}"));

    verify(guaManager).getGuaById(anyLong());
  }

  @Test
  void testGetGuaWithInvalidId() throws Exception {
    // Arrange
    long id = -1L;

    doThrow(new ResourceNotFoundException(String.format("No this gua.(id = %d)", id)))
        .when(guaManager)
        .getGuaById(anyLong());

    // Act && Assert
    mockMvc.perform(get("/api/v1/gua/" + id))
        .andExpect(status().is4xxClientError())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string(
            "{\"bizErrorCode\":\"INVALID_PARAMETER\",\"errorType\":\"CLINET\",\"message\":\"Use incorrect guaid = -1\",\"statusCode\":400}"));
    verify(guaManager, never()).getGuaById(anyLong());
  }
 
}
