package crud.service;

import crud.DAO.UserDao;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


   private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public User getUserById(Long id) {
      return userDao.getUserById(id);
   }

   @Transactional
   @Override
   public void update(Long id, User user) {
      userDao.update(id,user);
   }

   @Transactional
   @Override
   public void delete(Long id) {
      userDao.delete(id);
   }


}
