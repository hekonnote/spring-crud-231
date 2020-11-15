package tsoy.sergey.springCrud.dao;

import org.springframework.stereotype.Repository;
import tsoy.sergey.springCrud.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT user FROM User user WHERE user.id = :id", User.class);
        User user = query
                .setParameter("id", id)
                .getSingleResult();
        return user;
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void update(Long id, User updatedUser) {//реализация этого метода вызывает у меня сомнение
        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
    }



}
