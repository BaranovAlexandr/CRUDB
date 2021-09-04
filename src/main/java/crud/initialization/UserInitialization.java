package crud.initialization;

import crud.model.Role;
import crud.model.User;
import crud.service.RoleService;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserInitialization {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserInitialization(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    public void initRole() {
        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));

        Set<Role> adminRoles = new HashSet<>();
        Set<Role> userRoles = new HashSet<>();

        adminRoles.add(roleService.getRoleByName("ROLE_ADMIN"));
        userRoles.add(roleService.getRoleByName("ROLE_USER"));
//        User user = new User("alex","alex","Alexandr","Baranov", 23, adminRoles);
//        userService.add(user);
        userService.add(new User("alex","alex","Alexandr","Baranov", 23, adminRoles));
        userService.add(new User("admin", "admin", "Admin", "Admin", 30, adminRoles));
        userService.add(new User("user", "user", "user", "user", 20, userRoles));
        userService.add(new User("SU","SU","SimpleUser","SimpleUser", 22, userRoles));

    }
}


