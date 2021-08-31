package crud.control;


import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserConroller {

    private final UserService service;

    @Autowired
    public UserConroller(UserService service) {
        this.service = service;
//        service.add(new User("Alexandr","Baranov", 23));
//        service.add(new User("Alisa","Grishina", 23));
//        service.add(new User("Maria","Shirokaya", 22));
//        service.add(new User("Tema","LOH", 25));
    }

    @GetMapping()
    public String index(ModelMap model){
        model.addAttribute("users", service.listUsers());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("user", service.getUserById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        service.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("user", service.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user){
        service.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/users";
    }




}
