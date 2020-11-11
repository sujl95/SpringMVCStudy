package kr.thewing.springmvc;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents() {
        Event event1 = Event.builder()
                .name("Spring Web MVC Study 1차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020, 11, 11,4,00))
                .endDateTime(LocalDateTime.of(2020, 11, 11,12,00))
                .build();
        Event event2 = Event.builder()
                .name("Spring Web MVC Study 2차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020, 11, 12,4,00))
                .endDateTime(LocalDateTime.of(2020, 11, 12,12,00))
                .build();
        return List.of(event1, event2);
    }
}
