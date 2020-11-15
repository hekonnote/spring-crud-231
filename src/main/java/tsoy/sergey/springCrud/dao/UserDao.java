package tsoy.sergey.springCrud.dao;

import tsoy.sergey.springCrud.models.User;

import java.util.List;

//В приложении должна быть страница,
//  - на которую выводятся все юзеры с возможностью
//  - добавлять,
//  - удалять
//  - изменять юзера.

public interface UserDao {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public void add(User user);

    public void delete(Long id);

    public void update(Long id, User updatedUser);
}
