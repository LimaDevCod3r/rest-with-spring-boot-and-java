package br.LimaDevCod3r.Services;

import br.LimaDevCod3r.Model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {


    private final AtomicLong couter = new AtomicLong();
    // Cria logger para informação dessa clase
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        logger.info("Find All People");
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();

        person.setId(couter.incrementAndGet());
        person.setFirstname("Firstname " + i);
        person.setLastname("Lastname: " + i);
        person.setAddress("Adrress " + i);
        person.setGender("Gender " + i);
        return person;
    }

    public Person findById(String id) {
        logger.info("Find One Person");
        Person person = new Person();

        person.setId(couter.incrementAndGet());
        person.setFirstname("Diego");
        person.setLastname("Gonçalves");
        person.setAddress("Rua A");
        person.setGender("Masculino");

        return person;
    }

    public Person create(Person person) {
        logger.info("creating one Person");
        return person;
    }

    public Person update(Person person) {
        logger.info("updating one Person");
        return person;
    }

    public void delete(String id) {
        logger.info("deleting one Person");

    }

}
