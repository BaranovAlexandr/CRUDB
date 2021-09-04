package crud.controllers;

import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UControllerSec {


    UserService userService;

    @Autowired
    public UControllerSec(UserService userService) {
        this.userService = userService;
//        this.roleDAO = roleDAO;
////        Role userR = new Role("ROLE_USER");
////        Role adminR = new Role("ROLE_ADMIN");
//        Role adminR = roleDAO.getRoleByName("ROLE_ADMIN");
//
//        Set<Role> rolesAdmin = new HashSet<>();
//        rolesAdmin.add(adminR);
//
//        User user = new User("sanek","sanek", rolesAdmin, "Alexandr", "Baranov", 23 );
//        userService.add(user);


    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

}
