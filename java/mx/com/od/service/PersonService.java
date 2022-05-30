package mx.com.od.service;

import java.util.List;
import javax.ejb.Local;
import mx.com.od.entitymodel.Person;

/**
 *
 * @author Antonio Pérez Romero
 */
@Local
public interface PersonService {

    public List<Person> searchAllPeople();

    public Person searchPersonById(Person person);

    public Person searchPersonByEmail(Person person);

    public Person searchPersonByRFC(Person person);

    public Person searchPersonByCURP(Person person);

    public void addPerson(Person person);

    public void updatePerson(Person person);

    public void deletePerson(Person Person);
}
