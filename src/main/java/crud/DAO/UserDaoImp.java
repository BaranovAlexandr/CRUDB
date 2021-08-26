package crud.DAO;


import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

//   @Autowired
//   private SessionFactory sessionFactory;

//   @Qualifier("entityManagerFactory")
   @Autowired
   private EntityManagerFactory managerFactory;

   @Override
   public void add(User user) {
//      sessionFactory.getCurrentSession().save(user);
      managerFactory.createEntityManager().merge(user);
   }

   @Override
   public List<User> listUsers() {
//      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
//      return query.getResultList();
      Query query = managerFactory.createEntityManager().createQuery("SELECT p From User p",User.class);
      return query.getResultList();
   }



}
