package br.LimaDevCod3r.Services;

import br.LimaDevCod3r.Model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    // Simular o banco de dados
    private final Map<Long, Person> personDB = new HashMap<>();

    private final AtomicLong counter = new AtomicLong();
    // Cria logger para informação dessa clase
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        logger.info("Find All People");
        return new ArrayList<>(personDB.values());
    }


    public Person findById(Long id) {
        logger.info("Find One Person");
        return personDB.get(id);
    }

    public Person create(Person person) {
        long id = counter.incrementAndGet();
        person.setId(id);
        personDB.put(id, person);
        logger.info("Created person with ID " + id);
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating person with ID " + person.getId());

        if (person.getId() == null || !personDB.containsKey(person.getId())) {
            throw new RuntimeException("Person not found");
        }
        personDB.put(person.getId(), person);
        return person;
    }

    public void delete(Long id) {
        logger.info("Deleting person with ID " + id);
        personDB.remove(id);
    }
}
