package crud.DAO;


import crud.model.Role;
import java.util.List;


public interface RoleDao {

    void addRole(Role role);
    Role getRoleById(Long id);
}
