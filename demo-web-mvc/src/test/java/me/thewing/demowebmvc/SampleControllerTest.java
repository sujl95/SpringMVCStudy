package me.thewing.demowebmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

//@RunWith(SpringRunner.class) // spring이 제공해주는 테스트 클래스
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(get("/hello/sungjun.json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello sungjun"))
                .andExpect(handler().handlerType(SampleController.class))
                .andExpect(handler().methodName("helloSungjun"))
                ;

    }

}