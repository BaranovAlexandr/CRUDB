package crud.service;

import crud.model.Role;
import java.util.List;

public interface RoleService {
    void addRole(Role role);
    Role getRoleById(Long id);
}
