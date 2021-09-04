package crud.controllers;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserConroller {

    private final UserService service;


    @Autowired
    public UserConroller(UserService service) {
        this.service = service;
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Long id, ModelMap model){
//        model.addAttribute("user", service.getUserById(id));
//        return "users/show";
//    }
    @GetMapping("/user")
    public String showuser(ModelMap model, Principal principal){
        model.addAttribute("user", service.getUserByUsername(principal.getName()));
        return "users/show";
    }

    @GetMapping("/user/edit")
    public String edit(Principal principal, ModelMap model){
        model.addAttribute("user", service.getUserByUsername(principal.getName()));
        return "users/edit";
    }

//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") User user){
//        service.update(user);
//        return "redirect:/users/show";
//    }

    @DeleteMapping("/delite")
    public String delete(Principal principal) {
        service.delete(service.getUserByUsername(principal.getName()).getId());
        return "redirect:/hello";
    }

}
