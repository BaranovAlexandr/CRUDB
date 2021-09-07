package crud.service;

import crud.model.Role;
import java.util.List;

public interface RoleService {
    void addRole(Role role);
    void updateRole(Role role);
    void removeRoleById(long id);
    List<Role> getAllRoles();
    Role getRoleByName(String role);
    Role getRoleById(Long id);
}
