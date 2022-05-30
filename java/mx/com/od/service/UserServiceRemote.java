package mx.com.od.service;

import java.util.List;
import javax.ejb.Remote;
import mx.com.od.entitymodel.User;

/**
 *
 * @author Antonio Pérez Romero
 */
@Remote
interface UserServiceRemote {

    public List<User> searchAllUsersRemote();

}
