package me.thewing.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model) {
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "events/form";
    }

//    @PostMapping("/events")
//    @ResponseBody
//    public Event getEvent(@RequestBody Event event) {
////        Event event = new Event();
////        event.setName(name);
////        event.setLimit(limit);
//        return event;
//    }
    @PostMapping("/events/name/{name}")
    @ResponseBody
    public Event getEvent(@Valid @ModelAttribute Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("----------------------");
            bindingResult.getAllErrors().forEach(c -> {
                System.out.println(c.toString());
            });
        }
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

