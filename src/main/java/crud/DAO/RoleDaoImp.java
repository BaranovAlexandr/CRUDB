package crud.DAO;

import crud.model.Role;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void removeRoleById(long id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r").getResultList();
    }

    @Override
    public Role getRoleByName(String role) {
        Query query = entityManager.createQuery("Select e FROM Role e WHERE e.role = :role");
        query.setParameter("role", role);
        return (Role) query.getSingleResult();
    }

    @Override
    public Role getRoleById(Long id){
        Query query = entityManager.createQuery("Select e FROM Role e WHERE e.id = :id");
        query.setParameter("id", id);
        return (Role) query.getSingleResult();
    }
}
