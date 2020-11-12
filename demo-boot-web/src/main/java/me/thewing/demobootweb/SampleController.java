package me.thewing.demobootweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

//    @GetMapping("/hello/{name}")
//    public String hello(@PathVariable("name") Person person) {
//        return "hello " + person.getName();
//    }

//    @GetMapping("/hello")
//    public String hello(@PathVariable("name") Person person) {
//        return "hello " + person.getName();
//    }

//    @GetMapping("/hello")
//    public String hello(@RequestParam("name") Person person) {
//        return "hello " + person.getName();
//    }

    /**
     * preHandle : 전 처리,
     * 일반적인 서블릿 필터로 요청을 처리 하는데 구체적으로 처리 가능하다
     * 핸들러의 정보도 제공이 가능하다
     * 요청 처리
     * postHandler : 후 처리
     * 뷰 렌더링
     * afterCompletion
     *
     */


    @GetMapping("/hello")
    public String hello(@RequestParam("id")Person person) {
        System.out.println(person);
        return "hello " + person.getName();
    }



}
