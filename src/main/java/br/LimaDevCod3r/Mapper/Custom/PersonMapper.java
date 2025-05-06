package br.LimaDevCod3r.Mapper.Custom;

import br.LimaDevCod3r.Dto.v2.PersonDTOV2;
import br.LimaDevCod3r.Model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person) {
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(person.getId());
        dto.setFirstname(person.getFirstname());
        dto.setLastname(person.getLastname());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        dto.setBithday(new Date());
        return dto;
    }

    public Person convertDTOToEntity(PersonDTOV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstname(person.getFirstname());
        entity.setLastname(person.getLastname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        // entity.setBithday(new Date());
        return entity;
    }
}
