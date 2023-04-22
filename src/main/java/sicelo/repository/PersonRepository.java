package sicelo.repository;

import sicelo.domain.Person;

import java.util.*;

public class PersonRepository {
    private static final PersonRepository INSTANCE = new PersonRepository();

    private final Map<Integer, Person> personById;

    private PersonRepository(){
        super();
        this.personById = new LinkedHashMap<>();
    }

    public List<Person> findAll(){
        return new ArrayList<>(this.personById.values());
    }

    public Person findById(final int id){
        return this.personById.get(id);
    }

    public Optional<Person> findByEmail(final String email){
        return this.personById.values()
                .stream().
                filter(p -> p.getEmail().equals(email))
                .findFirst();
    }

     public static PersonRepository getInstance(){
        return INSTANCE;
     }
}
