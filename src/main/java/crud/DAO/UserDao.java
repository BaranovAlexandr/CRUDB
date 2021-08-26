package crud.DAO;


import crud.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

}
