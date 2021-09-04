package crud.service;

import crud.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUserById(Long id);
    void update(User user);
    void delete(Long id);
    User getUserByUsername(String username);
    void addFront(User user);
}
