package mx.com.od.dao;

import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.od.entitymodel.User;

/**
 *
 * @author Antonio Pérez Romero
 */
public class UserDaoImpl implements UserDAO {

    @PersistenceContext(unitName = "OpenDataPU")
    EntityManager entityManagerUser;

    @Override
    public List<User> searchAllUsers() {
        return entityManagerUser.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public User searchUserById(User user) {
        return entityManagerUser.find(User.class, user.getUserID());
    }

    @Override
    public User searchUserByAccountName(User user) {
        Query query = entityManagerUser.createQuery("SELECT u FROM User u WHERE u.userAccountName = :userAccountName");
        query.setParameter("userAccountName", user.getUserAccountName());
        return (User) query.getSingleResult();
    }

    @Override
    public void addUser(User user) {
        try {
            entityManagerUser.persist(user);
        } catch (EJBException ex) {
            System.out.println(">> Inserting User ..." + ex.getMessage());
        }
    }

    @Override
    public void updateUser(User user) {
        entityManagerUser.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManagerUser.remove(entityManagerUser.merge(user));
    }

}
