package tsoy.sergey.springCrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsoy.sergey.springCrud.dao.UserDao;
import tsoy.sergey.springCrud.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void update(Long id, User updatedUser) {
        userDao.update(id, updatedUser);
    }
}
