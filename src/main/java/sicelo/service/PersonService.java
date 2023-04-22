package sicelo.service;

import sicelo.domain.Person;
import sicelo.repository.PersonRepository;

import java.util.List;

public class PersonService {

    public PersonService(){
        super();
    }

    public List<Person> findAll(){
        return PersonRepository.getInstance().findAll();
    }

    public Person findById(int id){
        return PersonRepository.getInstance().findById(id);
    }
}

