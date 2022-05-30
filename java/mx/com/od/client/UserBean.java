package mx.com.od.client;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import mx.com.od.entitymodel.User;
import mx.com.od.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Antonio Pérez Romero
 */
@Named("userBean")
@RequestScoped
public class UserBean {

    Logger log = LogManager.getRootLogger();

    @Inject
    private UserService userService;

    private User userSelect;

    private List<User> users;

    public UserBean() {
        log.debug("Iniciando objeto UserBean");
    }

    @PostConstruct
    public void inicializar() {
        this.users = userService.searchAllUsers();
        log.debug("Users Recuperados -  ManagedBean: " + this.users);
        this.userSelect = new User();
    }

    public String login() {
        User u = this.userService.searchUserByAccountName(userSelect);
        if (u.getUserPassword().equals(userSelect.getUserPassword())) {
            if(u.getUserRol().equals("ADMIN_ROL")){
                return "registerTest";
            }else{
                return "dataTable";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Informacion de login incorrecta"));
            return "login";
        }
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
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
