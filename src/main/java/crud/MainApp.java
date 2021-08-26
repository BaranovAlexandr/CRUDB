package crud;

import crud.config.AppConfig;
import crud.config.AppInit;
import crud.model.User;
import crud.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);



      userService.add(new User("User1", "Lastname1", 21));
      userService.add(new User("User2", "Lastname2", 22));
      userService.add(new User("User3", "Lastname3", 23));
      userService.add(new User("User4", "Lastname4", 24));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getName());
         System.out.println("Last Name = "+user.getSurname());
         System.out.println("Age = "+user.getAge());
         System.out.println();
      }

      context.close();
   }
}
