package me.thewing.demojsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EventController {

    @GetMapping("/events")
    public String getEvents(Model model) {
        Event event1 = new Event();
        event1.setName("Spring Web MVC Study 1");
        event1.setStarts(LocalDateTime.of(2020,11,11,22,45));
        Event event2 = new Event();
        event1.setName("Spring Web MVC Study 2");
        event1.setStarts(LocalDateTime.of(2020,11,12,22,45));

        List<Event> events = List.of(event1, event2);

        model.addAttribute("events", events);
        model.addAttribute("message", "Happy 11Day");
        return "events/list";

    }
}
