package crud.DAO;

import crud.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class RoleDAO {

//    @PersistenceContext
//    private EntityManager em;
//
//    public void addRole(Role role) {
//        em.persist(role);
//    }
//
//    public void updateRole(Role role) {
//        em.merge(role);
//    }
//
//    public void removeRoleById(long id) {
//        em.remove(em.find(Role.class, id));
//    }
//
//    public List<Role> getAllRoles() {
//        return em.createQuery("select r from Role r").getResultList();
//    }
//
//    public Role getRoleByName(String role) {
//        TypedQuery<Role> queryRole = em.createQuery("select r from Role r where r.role=:role",
//                Role.class).setParameter("role", role);
//        return queryRole.getSingleResult();
//    }
}
