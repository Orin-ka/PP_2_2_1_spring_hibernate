package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void delete(User user){ sessionFactory.getCurrentSession().delete(user);}

   public List<User> carUser(String model, int series){
      String hql = """
         FROM User WHERE car.model = :paramModel and car.series = :paramSeries
         """;
      Query query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
      query.setParameter("paramModel", model);
      query.setParameter("paramSeries", series);
      List<User> users = query.getResultList();
      return users;
   }
}
