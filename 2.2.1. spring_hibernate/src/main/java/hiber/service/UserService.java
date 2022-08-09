package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;

import java.util.List;

public interface UserService extends UserDao {
    void add(User user);
    List<User> listUsers();

}
