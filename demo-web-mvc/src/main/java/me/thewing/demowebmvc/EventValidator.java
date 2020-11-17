package me.thewing.demowebmvc;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // 어떠한 도메인 클래스 Validation을 지원하는지
        // Event 클래스를 사용할때 Validation 적용
        return Event.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Event event = (Event) target;
        if (event.getName().equalsIgnoreCase("aaa")) {
            errors.rejectValue("name","wrongValue", "the value is not allowed");
        }
    }

//    public void validate(Event event, Errors errors) {
//        if (event.getName().equalsIgnoreCase("aaa")) {
//            errors.rejectValue("name","wrongValue", "the value is not allowed");
//        }
//    }
}
