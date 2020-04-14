package black.spring.boot.demo.service;

import black.spring.boot.demo.dao.PersonRepository;
import black.spring.boot.demo.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public int addPerson(Person person) {
        Person save = personRepository.save(person);
        return save.getPersonId();
    }

    public int countPersonNum() {
        return personRepository.countPersonNum();
    }
}
