package com.terremotospr.services.administrativeServices;

import com.terremotospr.beans.administrativeBeans.PersonBean;
import com.terremotospr.database.entities.administrativeEntities.Person;
import com.terremotospr.database.repositories.administrativeRepositories.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<PersonBean> fetchAllPerson() {
        //Ideally, controllers should return BEAN instead or entities.
        List<PersonBean> persons;
        Iterable<Person> iter = personRepository.findAll();

        //The repository works based on entities, thus we must convert them to beans (which are safer).
        //This method is widely used
        persons = StreamSupport.stream(iter.spliterator(), false)
                .map(this::convertPersonEntity)
                .collect(Collectors.toList());

        return persons;

     }

     //This method can be made generic and used in any bean conversion
     private PersonBean convertPersonEntity(Person person){
        PersonBean bean = new PersonBean();
         BeanUtils.copyProperties(person, bean);
         return bean;
     }

    public PersonBean fetchById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        PersonBean bean = new PersonBean();
        convertPersonEntity(person.get());
        return bean;
    }
}
