package me.thewing.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class SampleController {


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

//    @RequestMapping("/**")
//    @ResponseBody
//    public String hello() {
//        return "hello";
//    }

    @RequestMapping("/sungjun")
    @ResponseBody
    public String helloSungjun() {
        return "hello sungjun";
    }
}
