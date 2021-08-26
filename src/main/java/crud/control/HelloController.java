package crud.control;

import crud.model.User;
import crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	private final UserService service;

	public HelloController(UserService service) {
		this.service = service;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		service.add(new User("al", "bar", 22));
		List<User> messages = service.listUsers();
		model.addAttribute("messages", messages);
		return "index";
	}
	
}