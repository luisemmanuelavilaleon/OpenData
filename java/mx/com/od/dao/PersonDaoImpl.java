package mx.com.od.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.od.entitymodel.Person;

@Stateless
public class PersonDaoImpl implements PersonDAO {

    @PersistenceContext(unitName = "OpenDataPU")
    EntityManager entityManager;

    @Override
    public List<Person> searchAllPeople() {
        return entityManager.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public void addPerson(Person person) {
        entityManager.persist(person);
    }

    @Override
    public void updatePerson(Person person) {
        System.out.println("ACTUALIZO");
        entityManager.merge(person);
    }

    @Override
    public void deletePerson(Person person) {
        entityManager.remove(entityManager.merge(person));
    }

    @Override
    public Person searchPersonById(Person person) {
        return entityManager.find(Person.class, person.getPersonID());
    }

    @Override
    public Person searchPersonByEmail(Person person) {
        Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.personEmail = :personEmail");
        query.setParameter("personEmail", person.getPersonEmail());
        return (Person) query.getSingleResult();
    }

    @Override
    public Person searchPersonByRFC(Person Person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person searchPersonByCURP(Person Person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
