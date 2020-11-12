package me.thewing.demobootweb;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

//Web과 관련된 빈으로 인식하지 못해서 테스트 하지못한다
//@Component
public class PersonFormatter implements Formatter<Person> {

    @Override
    public Person parse(String text, Locale locale) throws ParseException {
        Person person = new Person();
        person.setName(text);
        return person;
    }

    @Override
    public String print(Person object, Locale locale) {
        return object.toString();
    }
}
