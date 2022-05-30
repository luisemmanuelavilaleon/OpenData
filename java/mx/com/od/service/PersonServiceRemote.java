package mx.com.od.service;

import java.util.List;
import javax.ejb.Remote;
import mx.com.od.entitymodel.Person;

/**
 *
 * @author Antonio Pérez Romero
 */
@Remote
public interface PersonServiceRemote {

    public List<Person> searchAllPeopleRemote();
}
