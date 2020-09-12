package user;

import com.fasterxml.classmate.GenericType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBHandler;

import java.util.List;

public class UserRepository {

    public void createUser(UserEntity user){
        Transaction transaction = null;

        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public UserEntity getUser(Integer id){
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            UserEntity user = session.find(UserEntity.class, id);
            return user;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void deleteUser(UserEntity user){
        Transaction transaction = null;
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateUser(UserEntity user){
        Transaction transaction = null;
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<UserEntity> getAllUsers(){
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            List<UserEntity> users = session.createQuery("from UserEntity", UserEntity.class).list();
            return users;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
