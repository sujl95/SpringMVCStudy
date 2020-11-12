package me.thewing.demobootweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest // Web과 관련된 Bean만 등록된다.
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception{
//        this.mockMvc.perform(get("/hello/sungjun"))
//                .andDo(print())
//                .andExpect(content().string("hello sungjun"));
//        this.mockMvc.perform(get("/hello")
//                .param("name","sungjun"))
//                .andDo(print())
//                .andExpect(content().string("hello sungjun"));
        //Test가 깨진이유 Web과 관련된 빈을 등록하기 때문에 깨진다
        this.mockMvc.perform(get("/hello")
                .param("id","1"))
                .andDo(print())
                .andExpect(content().string("hello sungjun"));

    }
}