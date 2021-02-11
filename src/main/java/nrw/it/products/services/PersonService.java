package nrw.it.products.services;

import nrw.it.products.Person;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class PersonService {

    private static Map<Long, Person> allPersons = new ConcurrentHashMap<>();
    private static AtomicLong personIdSeq = new AtomicLong();

    @PostConstruct
    public void init() {
        long id1 = personIdSeq.incrementAndGet();
        Person p1 = new Person(id1, "Donald", "Duck", 30);
        allPersons.put(id1, p1);

        long id2 = personIdSeq.incrementAndGet();
        Person p2 = new Person(id2, "Micky", "Maus", 35);
        allPersons.put(id2, p2);
    }

    public Long addPerson(Person newPerson) {
        Long nextid = personIdSeq.incrementAndGet();
        newPerson.setId(nextid);
        allPersons.put(nextid, newPerson);
        return nextid;
    }

    public void deletePerson(Long personId) {
        if (!allPersons.containsKey(personId)) {
            throw new RuntimeException("Person existiert nicht");
        }
        allPersons.remove(personId);
    }

    public Collection<Person> getAllPersons() {
        return allPersons.values();
    }

    public Person getById(Long personId) {
        return allPersons.get(personId);
    }
}
