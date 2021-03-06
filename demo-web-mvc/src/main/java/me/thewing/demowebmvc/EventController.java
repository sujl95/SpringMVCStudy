package me.thewing.demowebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Controller
@SessionAttributes("event")
public class EventController {

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model) {
        throw new EventException();
//        model.addAttribute("event", new Event()); //모델 addAttribute와 SessionAttributes 키 값이 같다면 동일하게 넣어준다
//        return "events/form-name";
    }

    @PostMapping("/events/form/name")
    public String eventsFormNameSubmit(@Validated @ModelAttribute Event event,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/events/form-name";
        }
//        eventValidator.validate(event, bindingResult);
        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event, Model model) {
        model.addAttribute("event", event);
        return "/events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String eventsFormLimitSubmit(@Validated @ModelAttribute Event event,
                                        BindingResult bindingResult,
                                        SessionStatus sessionStatus,
                                        RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "/events/form-limit";
        }
        sessionStatus.setComplete();
        attributes.addFlashAttribute("newEvent", event);
        return "redirect:/events/list";
    }


    @GetMapping("/events/list")
    public String getEvents(
//            @ModelAttribute("newEvent") Event event,
                            Model model,
                            @SessionAttribute LocalDateTime visitTime) {
        System.out.println("visitTime = " + visitTime);

        Event spring = new Event();
        spring.setName("spring");
        spring.setLimit(10);

        Event newEvent = (Event) model.asMap().get("newEvent"); //모델에서 가져올 수 있다.

        List<Event> eventList = new ArrayList<>();
        eventList.add(spring);
        eventList.add(newEvent);

        model.addAttribute(eventList);
        return "/events/list";
    }
}

