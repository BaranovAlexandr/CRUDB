package crud.service;

import crud.DAO.UserDao;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {


   private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }


   @Override
   public void add(User user) {
      userDao.add(user);
   }


   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }


   @Override
   public User getUserById(Long id) {
      return userDao.getUserById(id);
   }


   @Override
   public void update(User user) {
      userDao.update(user);
   }


   @Override
   public void delete(Long id) {
      userDao.delete(id);
   }

   @Override
   public User getUserByUsername(String username) {
      return userDao.getUserByUsername(username);
   }


}
