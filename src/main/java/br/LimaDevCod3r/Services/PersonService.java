package br.LimaDevCod3r.Services;

import br.LimaDevCod3r.Model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong couter = new AtomicLong();

    // Cria logger para informação dessa clase
    private Logger logger = Logger.getLogger(PersonService.class.getName());


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

}
