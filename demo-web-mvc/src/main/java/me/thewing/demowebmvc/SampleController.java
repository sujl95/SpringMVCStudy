package me.thewing.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @GetMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable Integer id, @MatrixVariable String name) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        return event;
    }

//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "hello";
//    }
//
//    @PostMapping("/hello")
//    @ResponseBody
//    public String helloPost() {
//        return "hello";
//    }
//
//    @PostMapping(
//            value = "/events",
//            consumes = MediaType.APPLICATION_JSON_VALUE
//    )
//    @ResponseBody
//    public String createEvent() {
//        return "events";
//    }
//
//
//    @GetMapping("/events/{id}")
//    @ResponseBody
//    public String getAnEvents(@PathVariable Long id) {
//        return "events";
//    }
//
//    @DeleteMapping("/events/{id}")
//    @ResponseBody
//    public String deleteAnEvents(@PathVariable Long id) {
//        return "events";
//    }
//
//    @PutMapping(
//            value = "/events",
//            consumes = MediaType.APPLICATION_JSON_VALUE
//    )
//    @ResponseBody
//    public String updateEvent() {
//        return "events";
//    }
//
//    @RequestMapping(value = "/hello",method = {RequestMethod.GET,RequestMethod.PUT}) //
//    @GetMapping({"/hello" , "/hi"}) //이렇게도 사용가능
//    @GetMapping("/hello")
//    @RequestMapping("/{name:[a-z]+}")
//    @ResponseBody //문자열을 응답
//    public String hello(@PathVariable String name) {
//        return "hello "+name; //해당하는 뷰를 찾는다
//    }
//    @RequestMapping({"/sungjun", "/sungjun.*"})
//    @ResponseBody
//    public String helloSungjun() {
//        return "hello sungjun";
//    }
//
//    @RequestMapping("/**")
//    @ResponseBody
//    public String hello() {
//        return "hello";
//    }
//
//    @RequestMapping("/sungjun")
//    @ResponseBody
//    public String helloSungjun() {
//        return "hello sungjun";
//    }
}

