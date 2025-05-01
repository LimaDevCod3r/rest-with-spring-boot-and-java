package br.LimaDevCod3r.Services;

import br.LimaDevCod3r.Exceptions.ResourceNotFoundException;
import br.LimaDevCod3r.Model.Person;
import br.LimaDevCod3r.Repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        logger.info("Find All People");
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Find One Person");
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public Person create(Person person) {
        logger.info("Created person with ID ");
        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating person with ID " + person.getId());

        var entity = this.findById(person.getId());

        entity.setFirstname(person.getFirstname());
        entity.setLastname(person.getLastname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting person with ID " + id);
        var entity = this.findById(id);
        personRepository.delete(entity);
    }
}
