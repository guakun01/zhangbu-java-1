package github.guakun01.zhangbujava1.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HelloControllerTest {

  private MockMvc mockMvc;

  @BeforeEach
  void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
  }

  @Test
  void testSayHi() throws Exception {
    // arrange && act && assert
    mockMvc.perform(get("/hi").param("name", "yyy"))
    .andExpect(status().isOk())
    .andExpect(content().string("hi, yyy"));

  }
  
}
