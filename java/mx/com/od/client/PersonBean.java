package mx.com.od.client;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import mx.com.od.entitymodel.Person;
import mx.com.od.entitymodel.User;
import mx.com.od.service.PersonService;
import mx.com.od.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Antonio Pérez Romero
 */
@Named("personBean")
@RequestScoped
public class PersonBean {

    Logger log;

    @Inject
    private PersonService personService;

    private Person personaSelected;

    @Inject
    private UserService userService;

    private User userSelect;

    List<Person> people;

    List<User> users;

    public PersonBean() {
    }

    @PostConstruct
    public void inicializar() {
        this.people = personService.searchAllPeople();
        this.users = userService.searchAllUsers();
        this.personaSelected = new Person();
        this.userSelect = new User();
        this.log = LogManager.getRootLogger();
    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void editListener(RowEditEvent event) {
        Person persona = (Person) event.getObject();
        personService.updatePerson(persona);
        addMessage(FacesMessage.SEVERITY_INFO, "User Edited", persona.getPersonName() +" has been edited succesfully!");
    }

    public void addPersonListener() {
        System.out.println(personaSelected.toString());
        this.personService.addPerson(personaSelected);
        this.people.add(personaSelected);
        this.personaSelected = null;
    }

    public void deletePersonListener() {
        this.personService.deletePerson(personaSelected);
        this.people.remove(personaSelected);
        addMessage(FacesMessage.SEVERITY_WARN, "User Deleted", personaSelected.getPersonName() + " has been deleted succesfully!");
        this.personaSelected = null;
    }

    public void restartPersonListener() {
        this.personaSelected = new Person();
    }

    public void addUserListener() {
        this.userSelect.setPersonID(personaSelected);
        this.userService.updateUser(userSelect);

        this.userService.addUser(userSelect);
        this.users.add(userSelect);
        addMessage(FacesMessage.SEVERITY_INFO, "User Edited", personaSelected.getPersonName() +" has been added to user " + userSelect.getUserAccountName());
        this.userSelect = null;
    }

    public String getPersonalInfo(int i ){
      return people.get(i).toString();
    }
    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public Person getPersonaSelected() {
        return personaSelected;
    }

    public void setPersonaSelected(Person personaSelected) {
        this.personaSelected = personaSelected;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUserSelect() {
        return userSelect;
    }

    public void setUserSelect(User userSelect) {
        this.userSelect = userSelect;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
