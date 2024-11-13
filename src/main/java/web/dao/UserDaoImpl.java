package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.model.User;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public List<User> userList() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void delete(int id) {
        em.remove(em.getReference(User.class, id));
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User updateUser(User user, int id) {
        return em.merge(user);
    }
}
