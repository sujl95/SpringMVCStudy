package kr.thewing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;


//    /**
//     * /hello/1?name=sunjun&age=26
//     * @param id
//     * @param name
//     * @return
//     */
//    @GetMapping("/hello/{id}")
//    @ResponseBody
//    public String hello(@PathVariable int id, @RequestParam String name) {
//        return "Hello, "+ helloService.getName();
//    }
//    /**
//     * /hello/1?name=sunjun&age=26
//     * @param id
//     * @param user
//     * @return
//     */
//    @GetMapping("/hello/{id}")
//    @ResponseBody
//    public String hello(@PathVariable int id, @ModelAttribute User user) {
//        return "Hello, "+ helloService.getName();
//    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, "+ helloService.getName();
    }

    @GetMapping("/sample")
    public String sample() {
//        return "/WEB-INF/sample.jsp";
        return "sample";
    }

}
