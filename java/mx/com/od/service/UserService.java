package mx.com.od.service;

import java.util.List;
import javax.ejb.Local;
import mx.com.od.entitymodel.User;

/**
 *
 * @author Antonio Pérez Romero
 */
@Local
public interface UserService {

    public List<User> searchAllUsers();

    public User searchUserById(User user);

    public User searchUserByAccountName(User user);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);
}
