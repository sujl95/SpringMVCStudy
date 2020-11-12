package me.thewing.demobootweb;

import me.thewing.demobootweb.Repository.PersonRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@WebMvcTest // Web과 관련된 Bean만 등록된다.
@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

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

        Person person = new Person();
        person.setName("sungjun");
        Person savedPerson = personRepository.save(person);
        System.out.println("savedPerson = " + savedPerson);

        this.mockMvc.perform(get("/hello")
                .param("id",savedPerson.getId().toString()))
                .andDo(print())
                .andExpect(content().string("hello sungjun"));

    }

    @Test
    public void helloStatic() throws Exception {
        this.mockMvc.perform(get("/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("hello index")))
        ;
    }
}