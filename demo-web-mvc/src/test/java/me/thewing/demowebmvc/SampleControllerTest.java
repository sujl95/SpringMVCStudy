package me.thewing.demowebmvc;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import static org.hamcrest.Matchers.notNullValue;
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
    public void eventForm() throws Exception {
        MockHttpServletRequest request = mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(view().name("events/form"))
                .andExpect(model().attributeExists("event"))
                .andExpect(request().sessionAttribute("event", notNullValue()))
                .andReturn().getRequest();
        Object event = request.getSession().getAttribute("event");
        System.out.println(event);
        ;
    }

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void postEvents() throws Exception {
        ResultActions result = mockMvc.perform(post("/events")
                .param("name", "sungjun")
                .param("limit", "-10")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasErrors());
        ModelAndView mav = result.andReturn().getModelAndView();
        Map<String, Object> model = mav.getModel();
        System.out.println(model.size());
    }

    @Test
    public void getEvents() throws Exception {
        Event newEvent = new Event();
        newEvent.setName("Winter is coming");
        newEvent.setLimit(2000);

        mockMvc.perform(get("/events/list")
                .sessionAttr("visitTime", LocalDateTime.now())
                .flashAttr("newEvent", newEvent))
                    .andDo(print())
                    .andExpect(status().isOk())
//                    .andExpect(xpath("//p").nodeCount(2))
        ;

    }



//    @Test
//    public void helloTest() throws Exception {
//        mockMvc.perform(get("/hello"))
//                .andDo(print())
//                .andExpect(status().isOk())
//        ;
//    }
//
//    @Test
//    public void getEvents() throws Exception {
//        mockMvc.perform(get("/events"))
//                .andDo(print())
//                .andExpect(status().isOk())
//        ;
//    }
//
//    @Test
//    public void getEventWithId() throws Exception {
//        mockMvc.perform(get("/events/1"))
//                .andExpect(status().isOk());
//        mockMvc.perform(get("/events/2"))
//                .andExpect(status().isOk());
//        mockMvc.perform(get("/events/3"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void createEvent() throws Exception {
//        mockMvc.perform(post("/events")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//        ).andExpect(status().isOk())
//        .andDo(print())
//
//        ;
//    }
//
//    @Test
//    public void deleteEvent() throws Exception {
//        mockMvc.perform(delete("/events/1"))
//                .andExpect(status().isOk());
//        mockMvc.perform(delete("/events/2"))
//                .andExpect(status().isOk());
//        mockMvc.perform(delete("/events/3"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void updateEvent() throws Exception {
//        mockMvc.perform(put("/events")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
}