package br.LimaDevCod3r.Services;

import br.LimaDevCod3r.Controllers.PersonController;
import br.LimaDevCod3r.Dto.v1.PersonDTO;
import br.LimaDevCod3r.Dto.v2.PersonDTOV2;
import br.LimaDevCod3r.Exceptions.RequiredObjectIsNullException;
import br.LimaDevCod3r.Exceptions.ResourceNotFoundException;
import br.LimaDevCod3r.Mapper.Custom.PersonMapper;
import br.LimaDevCod3r.Model.Person;
import br.LimaDevCod3r.Repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static br.LimaDevCod3r.Mapper.ObjectMapper.parseListObjects;
import static br.LimaDevCod3r.Mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;


    public List<PersonDTO> findAll() {

        logger.info("Finding all People!");

        var dtos = parseListObjects(repository.findAll(), PersonDTO.class);
        dtos.forEach(this::addHateoasLinks);
        return dtos;
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var dto = parseObject(entity, PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public PersonDTO create(PersonDTO person) {

        if(person == null) throw new RequiredObjectIsNullException();

        logger.info("Creating one Person!");
        var entity = parseObject(person, Person.class);

        var dto = parseObject(repository.save(entity), PersonDTO.class);

        addHateoasLinks(dto);
        return dto;
    }

    public PersonDTO update(PersonDTO person) {

        if(person == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstname(person.getFirstname());
        entity.setLastname(person.getLastname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var dto = parseObject(repository.save(entity), PersonDTO.class);

        addHateoasLinks(dto);
        return dto;
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    private  void addHateoasLinks(PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class)
                .findById(dto.getId()))
                .withSelfRel().withType("GET"));

        dto.add(linkTo(methodOn(PersonController.class)
                .delete(dto.getId()))
                .withRel("delete").withType("DELETE"));

        dto.add(linkTo(methodOn(PersonController.class)
                .findAll())
                .withRel("findAll").withType("GET"));

        dto.add(linkTo(methodOn(PersonController.class)
                .create(dto))
                .withRel("create").withType("POST"));

        dto.add(linkTo(methodOn(PersonController.class)
                .update(dto))
                .withRel("update").withType("PUT"));
    }
}
