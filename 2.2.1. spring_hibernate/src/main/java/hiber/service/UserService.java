package hiber.service;

import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<User> carUser(String model, int series);

    @Transactional
    void delete(User user);
}
