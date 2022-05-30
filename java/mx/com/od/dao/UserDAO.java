package mx.com.od.dao;

import java.util.List;
import mx.com.od.entitymodel.User;

/**
 *
 * @author Antonio Pérez Romero
 */
public interface UserDAO {

    public List<User> searchAllUsers();

    public User searchUserById(User user);

    public User searchUserByAccountName(User user);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

}
