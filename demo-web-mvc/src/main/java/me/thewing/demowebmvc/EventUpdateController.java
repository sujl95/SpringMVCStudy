package me.thewing.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE

)
public class EventUpdateController {
    @PutMapping(
            value = "/events",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public String updateEvent() {
        return "events";
    }

    @PostMapping(
            value = "/events",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public String createEvent() {
        return "events";
    }
}
