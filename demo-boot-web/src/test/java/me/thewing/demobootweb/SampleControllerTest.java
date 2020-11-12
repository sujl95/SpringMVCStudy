package me.thewing.demobootweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.thewing.demobootweb.Repository.PersonRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.oxm.Marshaller;
import org.springframework.test.web.servlet.MockMvc;


import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import java.io.StringWriter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@WebMvcTest // Web과 관련된 Bean만 등록된다.
@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    //Spring Boot에서 자동을 등록된다
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Marshaller marshaller;

    @Test
    public void jsonMessage() throws Exception {
        //jackson2 컨버터
        Person person = new Person();
        person.setId(2020l);
        person.setName("sungjun");

        String jsonString = objectMapper.writeValueAsString(person);

        this.mockMvc.perform(get("/jsonMessage")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2020))
                .andExpect(jsonPath("$.name").value("sungjun"))
                ;
    }

    @Test
    public void xmlMessage() throws Exception {
        //JAX2B 컨버터
        Person person = new Person();
        person.setId(2020l);
        person.setName("sungjun");
        //XML 변환 문자로 바꿔야한다

        StringWriter stringWriter = new StringWriter();
        Result result = new StreamResult(stringWriter);
        marshaller.marshal(person, result); // person 객체를 변환

        String xmlString = stringWriter.toString(); //xml을 꺼낸다

        this.mockMvc.perform(get("/jsonMessage")
                .contentType(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .content(xmlString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("person/name").string("sungjun"))
                .andExpect(xpath("person/id").string("2020"))
        ;
    }

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
        this.mockMvc.perform(get("/mobile/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("Hello Mobile")))
                .andExpect(header().exists(HttpHeaders.CACHE_CONTROL))
        ;
    }

    @Test
    public void stringMessage() throws Exception {
        this.mockMvc.perform(get("/message")
                .content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))
        ;
    }

}