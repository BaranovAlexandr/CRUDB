package crud.controllers;


import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService service;

    @Autowired
    public AdminController(UserService service) {
        this.service = service;
    }


    @GetMapping()
    public String index(ModelMap model){
        model.addAttribute("users", service.listUsers());
        return "admin/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("user", service.getUserById(id));
        return "admin/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "admin/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        service.addFront(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("user", service.getUserById(id));
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user){
        service.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/admin";
    }




}
