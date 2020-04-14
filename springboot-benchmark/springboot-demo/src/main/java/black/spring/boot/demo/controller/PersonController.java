package black.spring.boot.demo.controller;

import black.spring.boot.demo.model.Person;
import black.spring.boot.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {


    @Autowired
    private PersonService personService;

    @PostMapping(value = "saveCity")
    public String save(String name, int age) {
        Person person = new Person.Builder().personAge(age)
                .personName(name)
                .build();
        personService.addPerson(person);
        return "success";
    }

    @GetMapping(value = "count")
    public int count() {
        return personService.countPersonNum();
    }
}