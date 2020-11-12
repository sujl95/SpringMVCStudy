package me.thewing.demobootweb.Repository;

import me.thewing.demobootweb.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
