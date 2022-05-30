package mx.com.od.dao;

import java.util.List;
import mx.com.od.entitymodel.Person;

public interface PersonDAO {

    public List<Person> searchAllPeople();

    public Person searchPersonById(Person Person);

    public Person searchPersonByEmail(Person Person);

    public Person searchPersonByRFC(Person Person);

    public Person searchPersonByCURP(Person Person);

    public void addPerson(Person Person);

    public void updatePerson(Person Person);

    public void deletePerson(Person Person);
}
