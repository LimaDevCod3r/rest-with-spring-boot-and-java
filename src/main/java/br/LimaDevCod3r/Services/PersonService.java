package br.LimaDevCod3r.Services;

import br.LimaDevCod3r.Dto.PersonDTO;
import br.LimaDevCod3r.Exceptions.ResourceNotFoundException;
import br.LimaDevCod3r.Model.Person;
import br.LimaDevCod3r.Repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static br.LimaDevCod3r.Mapper.ObjectMapper.parseListObjects;
import static br.LimaDevCod3r.Mapper.ObjectMapper.parseObject;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    public List<PersonDTO> findAll() {
        logger.info("Find All People");
        return parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Find One Person");
        var entidy = personRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No records found for this id"));

        return parseObject(entidy, PersonDTO.class);

    }

    public PersonDTO create(PersonDTO person) {

        logger.info("Creating one Person!");
        var entity = parseObject(person, Person.class);

        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {

        logger.info("Updating one Person!");
        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstname(person.getFirstname());
        entity.setLastname(person.getLastname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }
}
