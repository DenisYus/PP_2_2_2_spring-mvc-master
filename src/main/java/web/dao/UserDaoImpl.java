package web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements  UserDao {
 @PersistenceContext
 private EntityManager entityManager;
 @Override
    public List<User> getUsers(){
 return entityManager.createQuery("select user from User user", User.class).getResultList();

 }
 @Override
 @Transactional
 public void addUser(User user){
  entityManager.persist(user);
 }
 @Override
 public User getUserById(long id){
  return entityManager.find(User.class,id);
 }

 @Override
 @Transactional
 public void removeUser(long id) {
  entityManager.remove(getUserById(id));
 }
 @Override
 @Transactional
 public void updateUser(User user) {
  entityManager.merge(user);
 }
}
