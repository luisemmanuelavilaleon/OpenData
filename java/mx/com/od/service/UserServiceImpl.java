package mx.com.od.service;

import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.od.dao.UserDAO;
import mx.com.od.entitymodel.User;

/**
 *
 * @author Antonio Pérez Romero
 */
@Stateless
public class UserServiceImpl implements UserService, UserServiceRemote {

    @Inject
    private UserDAO userDAO;

    @Override
    public List<User> searchAllUsers() {
        return userDAO.searchAllUsers();
    }

    @Override
    public List<User> searchAllUsersRemote() {
        return userDAO.searchAllUsers();
    }

    @Override
    public User searchUserById(User user) {
        return userDAO.searchUserById(user);
    }

    @Override
    public User searchUserByAccountName(User user) {
        return userDAO.searchUserByAccountName(user);
    }

    @Override
    public void addUser(User user) {
        try {
            userDAO.addUser(user);

        } catch (EJBException ex) {
            System.out.println(">> Inserting User ...");
        }

    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }
}
