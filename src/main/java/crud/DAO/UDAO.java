package crud.DAO;

import crud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional
public class UDAO {

    @PersistenceContext
    private EntityManager em;


    public User getUserByUsername(String username) {
        Query query = em.createQuery("Select e FROM User e WHERE e.username = :username");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }
}