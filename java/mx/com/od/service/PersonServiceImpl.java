package mx.com.od.service;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.od.dao.PersonDAO;
import mx.com.od.entitymodel.Person;

/**
 *
 * @author Antonio Pérez Romero
 */
@Stateless
public class PersonServiceImpl implements PersonServiceRemote, PersonService {
    
    @Inject
    private PersonDAO personDAO;
    
    @Resource
    private SessionContext context;
    
    @Override
    public List<Person> searchAllPeople() {
        return personDAO.searchAllPeople();
    }
    
    @Override
    public List<Person> searchAllPeopleRemote() {
        return personDAO.searchAllPeople();
    }
    
    @Override
    public Person searchPersonById(Person person) {
        return personDAO.searchPersonById(person);
    }
    
    @Override
    public Person searchPersonByEmail(Person person) {
        return personDAO.searchPersonByEmail(person);
    }
    
    @Override
    public Person searchPersonByRFC(Person person) {
        return personDAO.searchPersonByRFC(person);
    }
    
    @Override
    public Person searchPersonByCURP(Person person) {
        return personDAO.searchPersonByCURP(person);
    }
    
    @Override
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }
    
    @Override
    public void updatePerson(Person person) {
        //System.out.println("ACTUALIZO");
        try {
            personDAO.updatePerson(person);
        } catch (Throwable t) {
            context.setRollbackOnly();
            System.out.println(" >> Error (PersonServiceImpl|018) :" + t.getMessage());
        }
    }
    
    @Override
    public void deletePerson(Person person) {
        personDAO.deletePerson(person);
    }
}
