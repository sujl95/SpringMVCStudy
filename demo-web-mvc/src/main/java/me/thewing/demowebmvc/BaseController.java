package me.thewing.demowebmvc;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice(assignableTypes = {EventController.class, EventApi.class}) //전역으로 적용되는 컨트롤러
public class BaseController {

    @ExceptionHandler({EventException.class, RuntimeException.class}) // 타입을 둘다 받을 수 있는 상위타입으로 지정해야한다
    public String eventErrorHandler(RuntimeException exception, Model model) {
        model.addAttribute("message", "runtime error");
        return "error";
    }

    @InitBinder("event") //event로 바인딩 받을 때만 설정 가능
    public void initEventBinder(WebDataBinder webDataBinder) { // WebDataBinder 반드시 필요
        webDataBinder.setDisallowedFields("id"); //setDisallowedFields 받고 싶지 않은 필드 값을 거를 수 있다
        webDataBinder.addValidators(new EventValidator());
    }

    @ModelAttribute
    public void categories(Model model) {
        model.addAttribute("categories", List.of("study", "seminar", "hobby", "social"));
    }
}
